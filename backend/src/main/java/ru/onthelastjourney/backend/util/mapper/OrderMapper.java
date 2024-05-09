package ru.onthelastjourney.backend.util.mapper;

import ru.onthelastjourney.backend.dto.OrderDto;
import ru.onthelastjourney.backend.entity.Order;

import java.util.List;

public class OrderMapper {

    public static OrderDto toDto(Order order) {
        return new OrderDto(
                order.getClient(),
                order.getRegistrationDate(),
                order.getAppointmentDate(),
                order.getExecutionDate()
        );
    }

    public static List<OrderDto> toDto(List<Order> orders) {
        return orders.stream()
                .map(OrderMapper::toDto)
                .toList();
    }

    public static Order fromDto(OrderDto dto) {
        return Order.builder()
                .client(dto.getClient())
                .registrationDate(dto.getRegistrationDate())
                .appointmentDate(dto.getAppointmentDate())
                .executionDate(dto.getExecutionDate())
                .build();
    }

    public static List<Order> fromDto(List<OrderDto> dtos) {
        return dtos.stream()
                .map(OrderMapper::fromDto)
                .toList();
    }
}
