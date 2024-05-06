package ru.onthelastjourney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.onthelastjourney.backend.dto.OrderDto;
import ru.onthelastjourney.backend.entity.Order;
import ru.onthelastjourney.backend.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getById(@PathVariable(name = "orderId") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(service.save(orderDto));
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<Order>> saveAll(@RequestBody List<OrderDto> orderDtos) {
        return ResponseEntity.ok(service.saveAll(orderDtos));
    }

    @PutMapping
    public ResponseEntity<Order> update(@RequestBody Order order) {
        return ResponseEntity.ok(service.update(order));
    }

    @DeleteMapping
    public HttpStatus delete(@RequestBody Order order) {
        service.delete(order);

        return HttpStatus.OK;
    }

    @DeleteMapping("/{orderId}")
    public HttpStatus deleteById(@PathVariable(name = "orderId") Long id) {
        service.deleteById(id);

        return HttpStatus.OK;
    }
}
