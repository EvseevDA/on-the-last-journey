package ru.onthelastjourney.backend.util.factory;

import ru.onthelastjourney.backend.dto.ServiceOrderDto;
import ru.onthelastjourney.backend.entity.compositepk.ServiceOrderPk;

public class ServiceOrderPkFactory {

    public static ServiceOrderPk
    createServiceOrderByOrderIdAndServiceOrderDto(Long orderId, ServiceOrderDto serviceOrderDto) {
        return new ServiceOrderPk(
                OrderFactory.createOrderById(orderId),
                serviceOrderDto.getService()
        );
    }

    public static ServiceOrderPk createServiceOrderPkByOrderIdAndServiceId(Long orderId, Long serviceId) {
        return new ServiceOrderPk(
                OrderFactory.createOrderById(orderId),
                ServiceFactory.createServiceById(serviceId)
        );
    }

}
