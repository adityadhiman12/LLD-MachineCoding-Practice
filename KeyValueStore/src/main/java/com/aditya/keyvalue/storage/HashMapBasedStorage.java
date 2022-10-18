package com.aditya.keyvalue.storage;

import com.aditya.keyvalue.exceptions.NotFoundException;
import com.aditya.keyvalue.exceptions.StorageFullException;

import java.util.HashMap;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {
    private HashMap<Key, Value> storage;
    private int capacity;

    HashMapBasedStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();

    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isStorageFull())
            throw new StorageFullException("Capacity is full");
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) {
            throw new NotFoundException(key + "not found!");
        }
        storage.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if (!storage.containsKey(key)) {
            throw new NotFoundException(key + "not found!");
        }
        return storage.get(key);
    }
}
