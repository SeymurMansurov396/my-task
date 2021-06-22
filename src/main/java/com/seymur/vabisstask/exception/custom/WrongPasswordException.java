package com.seymur.vabisstask.exception.custom;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException(Throwable cause) {
        super(cause);
    }
}
