package com.br.userservice.application.exceptions;

public class DomainException extends RuntimeException {

    public DomainException(final String message) {
        super(message);
    }
}
