package br.com.guedes.jwt.resources.exceptions;

import br.com.guedes.jwt.services.exceptions.AuthorizationException;
import br.com.guedes.jwt.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectnotfound(ObjectNotFoundException e, HttpServletRequest http) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest http) {
        StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
