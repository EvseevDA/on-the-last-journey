package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.compositepk.OrderEmployeePk;
import ru.onthelastjourney.backend.entity.Employee;
import ru.onthelastjourney.backend.entity.Order;
import ru.onthelastjourney.backend.entity.OrderEmployee;
import ru.onthelastjourney.backend.repository.OrderEmployeeRepository;
import ru.onthelastjourney.backend.util.OrderEmployeeUtil;

import java.util.List;

@Service
public class OrderEmployeeService {

    private final OrderEmployeeRepository repository;

    @Autowired
    public OrderEmployeeService(OrderEmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployeesFromOrderWithId(Long id) {
        return OrderEmployeeUtil.employeesOnly(repository.findAllWhereOrderIdIs(id));
    }

    public Employee addEmployeeToOrderWithId(Long orderId, Employee employee) {
        OrderEmployee orderEmployee = createOrderEmployeeByOrderIdAndEmployee(orderId, employee);

        return OrderEmployeeUtil.employeeOnly(repository.save(orderEmployee));
    }

    public void deleteEmployeeFromOrderWithId(Long orderId, Employee employee) {
        OrderEmployeePk orderEmployeePk = createOrderEmployeePkByOrderIdAndEmployee(orderId, employee);

        repository.deleteById(orderEmployeePk);
    }

    public void deleteEmployeeFromOrderByOrderIdAndEmployeeId(Long orderId, Long employeeId) {
        OrderEmployeePk orderEmployeePk = createOrderEmployeePkByOrderIdAndEmployeeId(orderId, employeeId);

        repository.deleteById(orderEmployeePk);
    }


    /* private section */
    private static Order createOrderByOrderId(Long id) {
        return Order.builder().id(id).build();
    }

    private static Employee createEmployeeById(Long id) {
        return Employee.builder().id(id).build();
    }

    private static OrderEmployeePk createOrderEmployeePkByOrderIdAndEmployeeId(Long orderId, Long employeeId) {
        return new OrderEmployeePk(createOrderByOrderId(orderId), createEmployeeById(employeeId));
    }

    private static OrderEmployeePk createOrderEmployeePkByOrderIdAndEmployee(Long orderId, Employee employee) {
        return new OrderEmployeePk(createOrderByOrderId(orderId), employee);
    }

    private static OrderEmployee createOrderEmployeeByOrderIdAndEmployee(Long orderId, Employee employee) {
        return OrderEmployee.builder()
                .orderEmployeePk(createOrderEmployeePkByOrderIdAndEmployee(orderId, employee))
                .build();
    }

    // can be deleted
//    private static OrderEmployee createOrderEmployeeByOrderIdAndEmployeeId(Long orderId, Long employeeId) {
//        return OrderEmployee.builder()
//                .orderEmployeePk(createOrderEmployeePkByOrderIdAndEmployeeId(orderId, employeeId))
//                .build();
//    }

}
