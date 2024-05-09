package ru.onthelastjourney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.onthelastjourney.backend.dto.ServiceOrderDto;
import ru.onthelastjourney.backend.service.ServiceOrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders/{orderId}/services")
public class ServiceOrderController {

    private final ServiceOrderService service;

    @Autowired
    public ServiceOrderController(ServiceOrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServiceOrderDto>>
    getAllByOrderId(@PathVariable(name = "orderId") Long orderId) {
        return ResponseEntity.ok(service.getAllByOrderId(orderId));
    }

    @PostMapping
    public ResponseEntity<ServiceOrderDto>
    addServiceToOrderWithId(@PathVariable(name = "orderId") Long orderId,
                            @RequestBody ServiceOrderDto serviceOrderDto) {
        return ResponseEntity.ok(service.addServiceToOrderWithId(orderId, serviceOrderDto));
    }

    @PutMapping
    public ResponseEntity<ServiceOrderDto>
    updateServiceFromOrderWithId(@PathVariable(name = "orderId") Long orderId,
                                 @RequestBody ServiceOrderDto serviceOrderDto) {
        return ResponseEntity.ok(service.updateServiceFromOrderWithId(orderId, serviceOrderDto));
    }

    @DeleteMapping
    public HttpStatus deleteServiceFromOrderWithId(
            @PathVariable(name = "orderId") Long orderId,
            @RequestBody ServiceOrderDto serviceOrderDto) {
        service.deleteServiceFromOrderWithId(orderId, serviceOrderDto);

        return HttpStatus.OK;
    }

    @DeleteMapping("/{serviceId}")
    public HttpStatus deleteServiceFromOrderByOrderIdAndServiceId(
            @PathVariable(name = "orderId") Long orderId,
            @PathVariable(name = "serviceId") Long serviceId) {
        service.deleteServiceFromOrderByOrderIdAndServiceId(orderId, serviceId);

        return HttpStatus.OK;
    }
}
