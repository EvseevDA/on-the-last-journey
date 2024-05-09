package ru.onthelastjourney.backend.util.mapper;

import ru.onthelastjourney.backend.dto.OrderEmployeeDto;
import ru.onthelastjourney.backend.entity.OrderEmployee;

import java.util.List;

public class OrderEmployeeMapper {

    public static OrderEmployeeDto toDto(OrderEmployee employeeInOrder) {
        return new OrderEmployeeDto(employeeInOrder.getOrderEmployeePk().getEmployee());
    }

    public static List<OrderEmployeeDto> toDto(List<OrderEmployee> employeesInOrder) {
        return employeesInOrder.stream()
                .map(OrderEmployeeMapper::toDto)
                .toList();
    }

}
