package ru.onthelastjourney.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.onthelastjourney.backend.entity.AffilationType;
import ru.onthelastjourney.backend.entity.Provider;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FuneralAffilationDto {

    private Provider provider;

    private AffilationType affilationType;

    private String unit;

    private BigDecimal price;

    private Long inStorage;

    private Long expected;

    private Boolean suppliesStopped;

    private String photoUrl;

    private String name;

    private String description;

}
