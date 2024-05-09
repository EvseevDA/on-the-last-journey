package ru.onthelastjourney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.onthelastjourney.backend.dto.AffilationOrderDto;
import ru.onthelastjourney.backend.service.AffilationOrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders/{orderId}/affilations")
public class AffilationOrderController {

    private final AffilationOrderService service;

    @Autowired
    public AffilationOrderController(AffilationOrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AffilationOrderDto>>
    getAllByOrderId(@PathVariable(name = "orderId") Long orderId) {
        return ResponseEntity.ok(service.getAllByOrderId(orderId));
    }

    @PutMapping
    public ResponseEntity<AffilationOrderDto>
    updateAffilationFromOrderWithId(@PathVariable(name = "orderId") Long orderId,
                                    @RequestBody AffilationOrderDto affilationOrderDto) {
        return ResponseEntity.ok(service.updateAffilationFromOrderWithId(orderId, affilationOrderDto));
    }

    @PostMapping
    public ResponseEntity<AffilationOrderDto>
    addAffilationToOrderWithId(@PathVariable(name = "orderId") Long orderId,
                               @RequestBody AffilationOrderDto affilationOrderDto) {
        return ResponseEntity.ok(service.addAffilationToOrderWithId(orderId, affilationOrderDto));
    }

    @DeleteMapping
    public HttpStatus
    deleteAffilationFromOrderWithId(@PathVariable(name = "orderId") Long orderId,
                                    @RequestBody AffilationOrderDto affilationOrderDto) {
        service.deleteAffilationFromOrderWithId(orderId, affilationOrderDto);

        return HttpStatus.OK;
    }

    @DeleteMapping("/{affilationId}")
    public HttpStatus
    deleteAffilationFromOrderByOrderIdAndAffilationId(@PathVariable(name = "orderId") Long orderId,
                                                      @PathVariable(name = "affilationId") Long affilationId) {
        service.deleteAffilationFromOrderByOrderIdAndAffilationId(orderId, affilationId);

        return HttpStatus.OK;
    }
}
