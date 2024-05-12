package ru.onthelastjourney.backend.util.mapper;

import ru.onthelastjourney.backend.dto.ServiceOrderDto;
import ru.onthelastjourney.backend.entity.ServiceOrder;

import java.util.List;

public class ServiceOrderMapper {

    private ServiceOrderMapper() {
    }

    public static ServiceOrderDto toDto(ServiceOrder serviceInOrder) {
        return new ServiceOrderDto(
                serviceInOrder.getPk().getService(),
                serviceInOrder.getPrice(),
                serviceInOrder.getPercentDiscount()
        );
    }

    public static List<ServiceOrderDto> toDto(List<ServiceOrder> servicesInOrder) {
        return servicesInOrder.stream()
                .map(ServiceOrderMapper::toDto)
                .toList();
    }

}
