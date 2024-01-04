package org.example.api.advice;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<List<String>> handleException(WebExchangeBindException exception) {
        final List<String> errors = exception.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }
}
