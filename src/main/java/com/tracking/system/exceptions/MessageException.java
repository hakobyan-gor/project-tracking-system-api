package com.tracking.system.exceptions;

public class MessageException extends Exception {

    public MessageException(String message) {
        super(MessageException.generateMessage(message));
    }

    private static String generateMessage(String messages) {
        return messages;
    }

}