package ru.onthelastjourney.backend.util.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.onthelastjourney.backend.util.exception.ApplicationException;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;
import ru.onthelastjourney.backend.util.exception.ExceptionResponseBody;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponseBody> handleEntityNotFound(EntityNotFoundException e) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, e);
    }

    private ResponseEntity<ExceptionResponseBody>
    buildResponseEntity(HttpStatus status, ApplicationException e) {
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
