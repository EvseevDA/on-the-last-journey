package ru.onthelastjourney.backend.util.factory;

import ru.onthelastjourney.backend.entity.Employee;

public class EmployeeFactory {

    private EmployeeFactory() {
    }

    public static Employee createEmployeeById(Long id) {
        return Employee.builder().id(id).build();
    }

}
