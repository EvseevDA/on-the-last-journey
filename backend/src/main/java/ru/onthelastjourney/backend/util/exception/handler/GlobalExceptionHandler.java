package ru.onthelastjourney.backend.util.exception.handler;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;
import ru.onthelastjourney.backend.util.exception.ExceptionResponseBody;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponseBody> handleEntityNotFoundException(EntityNotFoundException e) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, e);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<ExceptionResponseBody> handlePsqlException(PSQLException e) {
        return responseEntityWithInternalServerError(e);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionResponseBody> handleNullPointerException(NullPointerException e) {
        return responseEntityWithInternalServerError(e);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponseBody>
    handleHttpMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return buildResponseEntity(HttpStatus.METHOD_NOT_ALLOWED, e);
    }

    private ResponseEntity<ExceptionResponseBody>
    responseEntityWithInternalServerError(Throwable e) {
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

    private ResponseEntity<ExceptionResponseBody>
    buildResponseEntity(HttpStatus status, Throwable e) {
        return ResponseEntity
                .status(status.value())
                .body(
                        ExceptionResponseBody
                                .builder()
                                .message(e.getMessage())
                                .timestamp(LocalDateTime.now())
                                .build()
                );
    }

}
