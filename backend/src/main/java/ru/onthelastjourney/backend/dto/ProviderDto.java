package ru.onthelastjourney.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProviderDto {

    private String name;

    private String speakTo;

    private String jobTitle;

    private String country;

    private String region;

    private String city;

    private String index;

    private String phoneNumber;

}
