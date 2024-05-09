package ru.onthelastjourney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.onthelastjourney.backend.dto.OrderEmployeeDto;
import ru.onthelastjourney.backend.service.OrderEmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/orders/{orderId}/employees")
public class OrderEmployeeController {

    private final OrderEmployeeService service;

    @Autowired
    public OrderEmployeeController(OrderEmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrderEmployeeDto>>
    getAllEmployeesFromOrderWithId(@PathVariable(name = "orderId") Long orderId) {
        return ResponseEntity.ok(service.getAllEmployeesFromOrderWithId(orderId));
    }

    @PostMapping
    public ResponseEntity<OrderEmployeeDto>
    addEmployeeToOrderWithId(@PathVariable(name = "orderId") Long orderId,
                             @RequestBody OrderEmployeeDto orderEmployeeDto) {
        return ResponseEntity.ok(service.addEmployeeToOrderWithId(orderId, orderEmployeeDto));
    }

    @DeleteMapping
    public HttpStatus
    deleteEmployeeFromOrderWithId(@PathVariable(name = "orderId") Long orderId,
                                  @RequestBody OrderEmployeeDto orderEmployeeDto) {
        service.deleteEmployeeFromOrderWithId(orderId, orderEmployeeDto);

        return HttpStatus.OK;
    }

    @DeleteMapping("/{employeeId}")
    public HttpStatus
    deleteEmployeeFromOrderByOrderIdAndEmployeeId(@PathVariable(name = "orderId") Long orderId,
                                                  @PathVariable(name = "employeeId") Long employeeId) {
        service.deleteEmployeeFromOrderByOrderIdAndEmployeeId(orderId, employeeId);

        return HttpStatus.OK;
    }
}
