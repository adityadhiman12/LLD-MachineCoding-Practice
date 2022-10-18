package com.aditya.keyvalue.exceptions;

public class StorageFullException extends RuntimeException{
    public StorageFullException(String message) {
        super(message);
    }
}
