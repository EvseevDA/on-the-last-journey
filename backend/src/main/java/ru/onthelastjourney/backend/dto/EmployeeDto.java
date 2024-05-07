package ru.onthelastjourney.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto {

    private String surname;

    private String name;

    private String patronymic;

    private String jobTitle;

    private LocalDateTime birthday;

    private LocalDateTime hireDate;

    private String country;

    private String region;

    private String city;

    private String district;

    private String street;

    private String houseNumber;

    private Long apartamentNumber;

    private String phoneNumber;

    private String photoUrl;

    private String note;

    private Long bossId;

}
