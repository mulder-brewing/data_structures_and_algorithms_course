package com.company.hashtable.model;

public class StoredObject<T> {

    public String key;
    public T obj;

    public StoredObject(String key, T obj) {
        this.key = key;
        this.obj = obj;
    }

    @Override
    public String toString() {
        return obj.toString();
    }
}
