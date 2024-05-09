package ru.onthelastjourney.backend.util.mapper;

import ru.onthelastjourney.backend.dto.AffilationOrderDto;
import ru.onthelastjourney.backend.entity.AffilationOrder;

import java.util.List;

public class AffilationOrderMapper {

    public static AffilationOrderDto toDto(AffilationOrder affilationInOrder) {
        return new AffilationOrderDto(
                affilationInOrder.getPk().getAffilation(),
                affilationInOrder.getPrice(),
                affilationInOrder.getAffilationCount(),
                affilationInOrder.getPercentDiscount()
        );
    }

    public static List<AffilationOrderDto> toDto(List<AffilationOrder> affilationsInOrder) {
        return affilationsInOrder.stream()
                .map(AffilationOrderMapper::toDto)
                .toList();
    }

}
