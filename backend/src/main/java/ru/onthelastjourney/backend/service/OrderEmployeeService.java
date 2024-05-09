package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.OrderEmployeeDto;
import ru.onthelastjourney.backend.entity.Employee;
import ru.onthelastjourney.backend.entity.Order;
import ru.onthelastjourney.backend.entity.OrderEmployee;
import ru.onthelastjourney.backend.entity.compositepk.OrderEmployeePk;
import ru.onthelastjourney.backend.repository.OrderEmployeeRepository;
import ru.onthelastjourney.backend.util.mapper.OrderEmployeeMapper;

import java.util.List;

@Service
public class OrderEmployeeService {

    private final OrderEmployeeRepository repository;

    @Autowired
    public OrderEmployeeService(OrderEmployeeRepository repository) {
        this.repository = repository;
    }

    public List<OrderEmployeeDto> getAllEmployeesFromOrderWithId(Long id) {
        return OrderEmployeeMapper.toDto(repository.findAllWhereOrderIdIs(id));
    }

    public OrderEmployeeDto addEmployeeToOrderWithId(Long orderId, OrderEmployeeDto dto) {
        return OrderEmployeeMapper.toDto(
                repository.save(createOrderEmployeeByOrderIdAndOrderEmployeeDto(orderId, dto))
        );
    }

    public void deleteEmployeeFromOrderWithId(Long orderId, OrderEmployeeDto dto) {
        repository.deleteById(
                createOrderEmployeePkByOrderIdAndOrderEmployeeDto(orderId, dto)
        );
    }

    public void deleteEmployeeFromOrderByOrderIdAndEmployeeId(Long orderId, Long employeeId) {
        repository.deleteById(
                createOrderEmployeePkByOrderIdAndEmployeeId(orderId, employeeId)
        );
    }


    /* private section */
    private static Order createOrderByOrderId(Long id) {
        return Order.builder().id(id).build();
    }

    private static Employee createEmployeeByEmployeeId(Long id) {
        return Employee.builder().id(id).build();
    }

    private static OrderEmployeePk createOrderEmployeePkByOrderIdAndEmployeeId(Long orderId, Long employeeId) {
        return new OrderEmployeePk(createOrderByOrderId(orderId), createEmployeeByEmployeeId(employeeId));
    }

    private static OrderEmployeePk createOrderEmployeePkByOrderIdAndOrderEmployeeDto(Long orderId, OrderEmployeeDto dto) {
        return new OrderEmployeePk(createOrderByOrderId(orderId), dto.getEmployee());
    }

    private static OrderEmployee createOrderEmployeeByOrderIdAndOrderEmployeeDto(Long orderId, OrderEmployeeDto dto) {
        return OrderEmployee.builder()
                .orderEmployeePk(createOrderEmployeePkByOrderIdAndOrderEmployeeDto(orderId, dto))
                .build();
    }

}
