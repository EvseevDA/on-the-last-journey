package ru.onthelastjourney.backend.util.factory;

import ru.onthelastjourney.backend.dto.OrderEmployeeDto;
import ru.onthelastjourney.backend.entity.OrderEmployee;

public class OrderEmployeeFactory {

    OrderEmployeeFactory() {
    }

    public static OrderEmployee createOrderEmployeeByOrderIdAndOrderEmployeeDto(Long orderId, OrderEmployeeDto orderEmployeeDto) {
        return OrderEmployee.builder()
                .pk(
                        OrderEmployeePkFactory.createOrderEmployeePkByOrderIdAndOrderEmployeeDto(
                                orderId, orderEmployeeDto
                        )
                )
                .build();
    }

}
