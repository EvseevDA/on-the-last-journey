package ru.onthelastjourney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.onthelastjourney.backend.dto.ServiceDto;
import ru.onthelastjourney.backend.entity.Service;
import ru.onthelastjourney.backend.service.ServiceService;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceService service;

    @Autowired
    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<Service>
    getById(@PathVariable(name = "serviceId") Long serviceId) throws EntityNotFoundException {
        return ResponseEntity.ok(service.getById(serviceId));
    }

    @PostMapping
    public ResponseEntity<Service> save(@RequestBody ServiceDto serviceDto) {
        return ResponseEntity.ok(service.save(serviceDto));
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<Service>> saveAll(@RequestBody List<ServiceDto> serviceDtos) {
        return ResponseEntity.ok(service.saveAll(serviceDtos));
    }

    @PutMapping
    public ResponseEntity<Service> update(@RequestBody Service $service) {
        return ResponseEntity.ok(service.update($service));
    }

    @DeleteMapping
    public HttpStatus delete(@RequestBody Service $service) {
        service.delete($service);

        return HttpStatus.OK;
    }

    @DeleteMapping("/{serviceId}")
    public HttpStatus deleteById(@PathVariable(name = "serviceId") Long serviceId) {
        service.deleteById(serviceId);

        return HttpStatus.OK;
    }
}
