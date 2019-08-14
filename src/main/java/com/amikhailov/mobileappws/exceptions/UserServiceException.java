package com.amikhailov.mobileappws.exceptions;

public class UserServiceException extends RuntimeException{

    private static final long serialVersionUID = -1643996073875019186L;

    public UserServiceException(String message) {
        super(message);
    }
}
