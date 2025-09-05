package com.sanket.jms.exception;

public class InvalidRecipientException extends RuntimeException {
    public InvalidRecipientException(String message) {
        super(message);
    }
}