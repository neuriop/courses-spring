package com.example.app3.errors;

public class ServerRequestException extends RuntimeException {
    public ServerRequestException(String message) {
        super(message);
    }
}
