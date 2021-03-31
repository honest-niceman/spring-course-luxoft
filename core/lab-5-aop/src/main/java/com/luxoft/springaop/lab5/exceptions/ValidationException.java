package com.luxoft.springaop.lab5.exceptions;

public class ValidationException extends RuntimeException {
    public ValidationException(String s) {
        System.out.println(s);
    }
}
