package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.OrderEmployeeDto;
import ru.onthelastjourney.backend.repository.OrderEmployeeRepository;
import ru.onthelastjourney.backend.util.factory.OrderEmployeeFactory;
import ru.onthelastjourney.backend.util.factory.OrderEmployeePkFactory;
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
                repository.save(
                        OrderEmployeeFactory.createOrderEmployeeByOrderIdAndOrderEmployeeDto(orderId, dto)
                )
        );
    }

    public void deleteEmployeeFromOrderWithId(Long orderId, OrderEmployeeDto dto) {
        repository.deleteById(
                OrderEmployeePkFactory.createOrderEmployeePkByOrderIdAndOrderEmployeeDto(orderId, dto)
        );
    }

    public void deleteEmployeeFromOrderByOrderIdAndEmployeeId(Long orderId, Long employeeId) {
        repository.deleteById(
                OrderEmployeePkFactory.createOrderEmployeePkByOrderIdAndEmployeeId(orderId, employeeId)
        );
    }

}
