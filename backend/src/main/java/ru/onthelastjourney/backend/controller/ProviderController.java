package ru.onthelastjourney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.onthelastjourney.backend.dto.ProviderDto;
import ru.onthelastjourney.backend.entity.Provider;
import ru.onthelastjourney.backend.service.ProviderService;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    private final ProviderService service;

    @Autowired
    public ProviderController(ProviderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Provider>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{providerId}")
    public ResponseEntity<Provider>
    getById(@PathVariable(name = "providerId") Long providerId) throws EntityNotFoundException {
        return ResponseEntity.ok(service.getById(providerId));
    }

    @PostMapping
    public ResponseEntity<Provider> save(@RequestBody ProviderDto providerDto) {
        return ResponseEntity.ok(service.save(providerDto));
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<Provider>> saveAll(@RequestBody List<ProviderDto> providerDtos) {
        return ResponseEntity.ok(service.saveAll(providerDtos));
    }

    @PutMapping
    public ResponseEntity<Provider> update(@RequestBody Provider provider) {
        return ResponseEntity.ok(service.update(provider));
    }

    @DeleteMapping
    public HttpStatus delete(@RequestBody Provider provider) {
        service.delete(provider);

        return HttpStatus.OK;
    }

    @DeleteMapping("/{providerId}")
    public HttpStatus deleteById(@PathVariable(name = "providerId") Long providerId) {
        service.deleteById(providerId);

        return HttpStatus.OK;
    }
}
