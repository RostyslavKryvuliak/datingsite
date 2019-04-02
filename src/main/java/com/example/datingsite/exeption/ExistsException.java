package com.example.datingsite.exeption;

public class ExistsException extends  RuntimeException{

    public ExistsException(String message) {
        super(message);
    }
}
