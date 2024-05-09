package ru.onthelastjourney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.onthelastjourney.backend.dto.AffilationTypeDto;
import ru.onthelastjourney.backend.entity.AffilationType;
import ru.onthelastjourney.backend.service.AffilationTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/affilation-types")
public class AffilationTypeController {

    private final AffilationTypeService service;

    @Autowired
    public AffilationTypeController(AffilationTypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AffilationType>> getAll() {
        return ResponseEntity.ok((service.getAll()));
    }

    @GetMapping("/{affilationTypeId}")
    public ResponseEntity<AffilationType>
    getById(@PathVariable(name = "affilationTypeId") Long affilationTypeId) {
        return ResponseEntity.ok(service.getById(affilationTypeId));
    }

    @PostMapping
    public ResponseEntity<AffilationType> save(@RequestBody AffilationTypeDto affilationTypeDto) {
        return ResponseEntity.ok(service.save(affilationTypeDto));
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<AffilationType>>
    saveAll(@RequestBody List<AffilationTypeDto> affilationTypeDtos) {
        return ResponseEntity.ok(service.saveAll(affilationTypeDtos));
    }

    @PutMapping
    public ResponseEntity<AffilationType> update(@RequestBody AffilationType affilationType) {
        return ResponseEntity.ok(service.update(affilationType));
    }

    @DeleteMapping
    public HttpStatus delete(@RequestBody AffilationType affilationType) {
        service.delete(affilationType);

        return HttpStatus.OK;
    }

    @DeleteMapping("/{affilationTypeId}")
    public HttpStatus
    deleteById(@PathVariable(name = "affilationTypeId") Long affilationTypeId) {
        service.deleteById(affilationTypeId);

        return HttpStatus.OK;
    }
}
