package com.company.hashtable.model;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProbeHashtable<T> {

    private StoredObject<T>[] hashtable;

    public ProbeHashtable() {
        hashtable = (StoredObject<T>[]) Array.newInstance(StoredObject.class, 10);
    }

    public void put(String key, T obj) {
        int hashKey = hashKey(key);

        if (isOccupied(hashKey)) {
            int stopIndex = hashKey;
            if (hashKey == hashtable.length - 1) {
                hashKey = 0;
            } else {
                hashKey++;
            }

            while (isOccupied(hashKey) && hashKey != stopIndex) {
                hashKey = (hashKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashKey)) {
            System.out.println("Sorry, there's already an employee at position " + hashKey);
        } else {
            hashtable[hashKey] = new StoredObject<T>(key, obj);
        }
    }

    public T get(String key) {
        int hashedKey = findKey(key);
        return hashedKey != -1 ? hashtable[hashedKey].obj : null;
    }

    public T remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        T obj = hashtable[hashedKey].obj;
        hashtable[hashedKey] = null;

        // Rehash
        StoredObject<T>[] oldHashTable = hashtable;
        hashtable = (StoredObject<T>[]) Array.newInstance(StoredObject.class, oldHashTable.length);
        for (int i = 0; i < oldHashTable.length; i++) {
            if (oldHashTable[i] != null) {
                put(oldHashTable[i].key, oldHashTable[i].obj);
            }
        }

        return obj;
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private int findKey(String key) {
        int hashKey = hashKey(key);
        if (hashtable[hashKey] != null && hashtable[hashKey].key.equals(key)) {
            return hashKey;
        }

        // linear probing to find it
        int stopIndex = hashKey;
        if (hashKey == hashtable.length - 1) {
            hashKey = 0;
        } else {
            hashKey++;
        }

        while (hashKey != stopIndex && hashtable[hashKey] != null && !hashtable[hashKey].key.equals(key)) {
            hashKey = (hashKey + 1) % hashtable.length;
        }

        if (hashtable[hashKey] != null && hashtable[hashKey].key.equals(key)) {
            return hashKey;
        } else {
            return -1;
        }
    }

    private boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashTable() {
        System.out.println(Arrays.toString(hashtable));
    }
}
