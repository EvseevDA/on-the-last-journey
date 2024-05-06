package ru.onthelastjourney.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.onthelastjourney.backend.entity.Client;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {

    private Client client;

    private LocalDateTime registrationDate;

    private LocalDateTime appointmentDate;

    private LocalDateTime executionDate;

}
