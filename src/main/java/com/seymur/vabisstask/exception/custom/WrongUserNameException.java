package com.seymur.vabisstask.exception.custom;

public class WrongUserNameException extends RuntimeException {
    public WrongUserNameException() {
    }

    public WrongUserNameException(String message) {
        super(message);
    }

    public WrongUserNameException(Throwable cause) {
        super(cause);
    }
}
