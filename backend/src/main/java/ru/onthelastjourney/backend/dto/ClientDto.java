package ru.onthelastjourney.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDto {

    private String surname;

    private String name;

    private String patronymic;

    private String country;

    private String region;

    private String city;

    private String phoneNumber;

    private Integer index;

}
