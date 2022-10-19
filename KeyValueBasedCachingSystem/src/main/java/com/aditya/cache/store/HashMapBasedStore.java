package com.aditya.cache.store;

import com.aditya.cache.exceptions.NotFoundException;
import com.aditya.cache.exceptions.StorageFullException;

import java.util.HashMap;

public class HashMapBasedStore<Key, Value> implements Store<Key, Value>{
    private int capacity;
    private HashMap<Key, Value> storage;
    
    HashMapBasedStore(Integer capacity) {
        this.capacity=capacity;
        this.storage=new HashMap<>();
    }
    
    private boolean isStorageFull() {
        return this.capacity==storage.size();
    }
    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if(isStorageFull())
            throw new StorageFullException("Storage is Full");
        this.storage.put(key, value);
    }

    @Override
    public Value get(Key key) {
        if(!storage.containsKey(key)) {
            throw new NotFoundException("Key not found!");
        }
        return this.storage.get(key);
    }
}
