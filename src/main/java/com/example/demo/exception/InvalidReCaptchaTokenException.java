package com.example.demo.exception;

public class InvalidReCaptchaTokenException extends Exception{
    public InvalidReCaptchaTokenException(String message) {
        super(message);
    }
}
