package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.OrderEmployeeDto;
import ru.onthelastjourney.backend.repository.OrderEmployeeRepository;
import ru.onthelastjourney.backend.util.mapper.OrderEmployeeMapper;

import java.util.List;

@Service
public class OrderEmployeeService extends AbstractService {

    private final OrderEmployeeRepository repository;

    @Autowired
    public OrderEmployeeService(OrderEmployeeRepository repository) {
        this.repository = repository;
    }

    public List<OrderEmployeeDto> getAllEmployeesFromOrderWithId(Long id) {
        return OrderEmployeeMapper.toDto(repository.findAllByOrderId(id));
    }

    public OrderEmployeeDto addEmployeeToOrderWithId(Long orderId, OrderEmployeeDto dto) {
        repository.saveByDbFields(orderId, dto.getEmployee().getId());

        return dto;
    }

    public void deleteEmployeeFromOrderWithId(Long orderId, OrderEmployeeDto dto) {
        repository.deleteByDbFields(orderId, dto.getEmployee().getId());
    }

    public void deleteEmployeeFromOrderByOrderIdAndEmployeeId(Long orderId, Long employeeId) {
        repository.deleteByDbFields(orderId, employeeId);
    }

}
