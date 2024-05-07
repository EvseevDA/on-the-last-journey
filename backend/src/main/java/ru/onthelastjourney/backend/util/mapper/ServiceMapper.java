package ru.onthelastjourney.backend.util.mapper;

import ru.onthelastjourney.backend.dto.ServiceDto;
import ru.onthelastjourney.backend.entity.Service;

import java.util.List;

public class ServiceMapper {

    public static ServiceDto toDto(Service service) {
        return new ServiceDto(
                service.getName(),
                service.getDescription(),
                service.getPrice()
        );
    }

    public static List<ServiceDto> toDto(List<Service> services) {
        return services.stream()
                .map(ServiceMapper::toDto)
                .toList();
    }

    public static Service fromDto(ServiceDto dto) {
        return Service.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }

    public static List<Service> fromDto(List<ServiceDto> dtos) {
        return dtos.stream()
                .map(ServiceMapper::fromDto)
                .toList();
    }
}
