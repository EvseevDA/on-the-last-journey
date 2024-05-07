package ru.onthelastjourney.backend.util;

import ru.onthelastjourney.backend.entity.Employee;
import ru.onthelastjourney.backend.entity.OrderEmployee;

import java.util.List;

public class OrderEmployeeUtil {

    public static Employee employeeOnly(OrderEmployee employeeInOrder) {
        return employeeInOrder.getOrderEmployeePk().getEmployee();
    }

    public static List<Employee> employeesOnly(List<OrderEmployee> employeesInOrders) {
        return employeesInOrders.stream()
                .map(OrderEmployeeUtil::employeeOnly)
                .toList();
    }

}
