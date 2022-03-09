package com.EscamboIO.EscamboIO.controller.exceptions;

import com.EscamboIO.EscamboIO.services.exceptions.ResourceNotFoundException;
import com.EscamboIO.EscamboIO.services.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError(Instant.now(), status.value(), "Validation exception", "Erro de validação", request.getRequestURI());
        for(FieldError x : e.getBindingResult().getFieldErrors()){
            error.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<StandardError> unauthorized(UnauthorizedException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError(Instant.now(), status.value(), "Não Autorizado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> notFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(Instant.now(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
