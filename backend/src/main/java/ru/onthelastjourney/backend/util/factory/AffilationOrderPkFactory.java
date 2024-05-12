package ru.onthelastjourney.backend.util.factory;

import ru.onthelastjourney.backend.dto.AffilationOrderDto;
import ru.onthelastjourney.backend.entity.compositepk.AffilationOrderPk;

public class AffilationOrderPkFactory {

    private AffilationOrderPkFactory() {
    }

    public static AffilationOrderPk
    createAffilationOrderPkByOrderIdAndAffilationOrderDto(Long orderId, AffilationOrderDto affilationOrderDto) {
        return new AffilationOrderPk(
                OrderFactory.createOrderById(orderId),
                affilationOrderDto.getAffilation()
        );
    }

    public static AffilationOrderPk
    createAffilationOrderPkByOrderIdAndFuneralAffilationId(Long orderId, Long affilationId) {
        return new AffilationOrderPk(
                OrderFactory.createOrderById(orderId),
                FuneralAffilationFactory.createFuneralAffilationById(affilationId)
        );
    }

}
