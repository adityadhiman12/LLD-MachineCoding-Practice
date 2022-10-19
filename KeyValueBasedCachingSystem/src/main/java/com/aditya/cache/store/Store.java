package com.aditya.cache.store;

public interface Store<Key, Value> {
    public void add(Key key, Value value);
    public Value get(Key key);


}
