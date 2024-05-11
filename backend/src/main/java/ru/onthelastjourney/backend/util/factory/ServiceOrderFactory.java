package ru.onthelastjourney.backend.util.factory;

import ru.onthelastjourney.backend.dto.ServiceOrderDto;
import ru.onthelastjourney.backend.entity.ServiceOrder;

public class ServiceOrderFactory {

    public static ServiceOrder
    createServiceOrderByOrderIdAndServiceOrderDto(Long orderId, ServiceOrderDto serviceOrderDto) {
        return ServiceOrder.builder()
                .pk(ServiceOrderPkFactory.createServiceOrderByOrderIdAndServiceOrderDto(orderId, serviceOrderDto))
                .price(serviceOrderDto.getPrice())
                .percentDiscount(serviceOrderDto.getPercentDiscount())
                .build();
    }

}
