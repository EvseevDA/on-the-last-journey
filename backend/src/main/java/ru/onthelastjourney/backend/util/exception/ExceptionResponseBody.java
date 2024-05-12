package ru.onthelastjourney.backend.util.exception;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ExceptionResponseBody {

    private String message;

    private LocalDateTime timestamp;

}
