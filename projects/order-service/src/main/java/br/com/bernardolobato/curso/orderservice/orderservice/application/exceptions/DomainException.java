package br.com.bernardolobato.curso.orderservice.orderservice.application.exceptions;

public class DomainException extends RuntimeException {
    public DomainException(final String message) {
        super(message);
    }
}
