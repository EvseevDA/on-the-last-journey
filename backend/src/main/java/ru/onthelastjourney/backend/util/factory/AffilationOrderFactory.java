package ru.onthelastjourney.backend.util.factory;

import ru.onthelastjourney.backend.dto.AffilationOrderDto;
import ru.onthelastjourney.backend.entity.AffilationOrder;

public class AffilationOrderFactory {

    private AffilationOrderFactory() {
    }

    public static AffilationOrder
    createAffilationOrderByOrderIdAndAffilationOrderDto(Long orderId, AffilationOrderDto affilationOrderDto) {
        return AffilationOrder.builder()
                .pk(
                        AffilationOrderPkFactory
                                .createAffilationOrderPkByOrderIdAndAffilationOrderDto(
                                        orderId, affilationOrderDto
                                )
                )
                .price(affilationOrderDto.getPrice())
                .affilationCount(affilationOrderDto.getAffilationCount())
                .percentDiscount(affilationOrderDto.getPercentDiscount())
                .build();
    }

}
