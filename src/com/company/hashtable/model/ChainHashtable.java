package com.company.hashtable.model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class ChainHashtable<T> {

    private LinkedList<StoredObject<T>>[] hashtable;

    public ChainHashtable() {
        hashtable = (LinkedList<StoredObject<T>>[]) Array.newInstance(LinkedList.class, 10);
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<>();
        }
    }

    public void put(String key, T obj) {
        int hashKey = hashKey(key);
        hashtable[hashKey].add(new StoredObject<>(key, obj));
    }

    public T get(String key) {
        StoredObject<T> sObj = findStoredObject(key);
        return sObj != null ? sObj.obj : null;
    }

    public T remove(String key) {
        StoredObject<T> sObj = findStoredObject(key);
        if (sObj == null) {
            return null;
        }
        hashtable[hashKey(key)].remove(sObj);
        return sObj.obj;
    }

    private int hashKey(String key) {
        return Math.abs(key.hashCode() % hashtable.length);
    }

    private StoredObject<T> findStoredObject(String key) {
        return hashtable[hashKey(key)].stream().filter(o -> o.key == key).findFirst().orElse(null);
    }

    public void printHashTable() {
        System.out.println(Arrays.toString(hashtable));
    }
}