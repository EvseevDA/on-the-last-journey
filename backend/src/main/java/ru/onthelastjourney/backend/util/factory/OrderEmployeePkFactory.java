package ru.onthelastjourney.backend.util.factory;

import ru.onthelastjourney.backend.dto.OrderEmployeeDto;
import ru.onthelastjourney.backend.entity.compositepk.OrderEmployeePk;

public class OrderEmployeePkFactory {

    private OrderEmployeePkFactory() {
    }

    public static OrderEmployeePk
    createOrderEmployeePkByOrderIdAndOrderEmployeeDto(Long orderId, OrderEmployeeDto orderEmployeeDto) {
        return new OrderEmployeePk(
                OrderFactory.createOrderById(orderId),
                orderEmployeeDto.getEmployee()
        );
    }

    public static OrderEmployeePk createOrderEmployeePkByOrderIdAndEmployeeId(Long orderId, Long employeeId) {
        return new OrderEmployeePk(
                OrderFactory.createOrderById(orderId),
                EmployeeFactory.createEmployeeById(employeeId)
        );
    }

}
