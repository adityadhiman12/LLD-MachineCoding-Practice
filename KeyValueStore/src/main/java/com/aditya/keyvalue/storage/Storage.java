package com.aditya.keyvalue.storage;

public interface Storage <Key, Value>{
    public void add(Key key, Value value);
    public void remove(Key key);
    public Value get(Key key);
}
