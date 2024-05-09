package ru.onthelastjourney.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.onthelastjourney.backend.entity.FuneralAffilation;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AffilationOrderDto {

    private FuneralAffilation affilation;

    private BigDecimal price;

    private Long affilationCount;

    private Long percentDiscount;

}
