package ru.onthelastjourney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.onthelastjourney.backend.dto.FuneralAffilationDto;
import ru.onthelastjourney.backend.entity.FuneralAffilation;
import ru.onthelastjourney.backend.service.FuneralAffilationService;

import java.util.List;

@RestController
@RequestMapping("/funeral-affilations")
public class FuneralAffilationController {

    private final FuneralAffilationService service;

    @Autowired
    public FuneralAffilationController(FuneralAffilationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FuneralAffilation>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{funeralAffilationId}")
    public ResponseEntity<FuneralAffilation>
    getById(@PathVariable(name = "funeralAffilationId") Long funeralAffilationId) {
        return ResponseEntity.ok(service.getById(funeralAffilationId));
    }

    @PostMapping
    public ResponseEntity<FuneralAffilation>
    save(@RequestBody FuneralAffilationDto funeralAffilationDto) {
        return ResponseEntity.ok(service.save(funeralAffilationDto));
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<FuneralAffilation>>
    saveAll(@RequestBody List<FuneralAffilationDto> funeralAffilationDtos) {
        return ResponseEntity.ok(service.saveAll(funeralAffilationDtos));
    }

    @PutMapping
    public ResponseEntity<FuneralAffilation>
    update(@RequestBody FuneralAffilation funeralAffilation) {
        return ResponseEntity.ok(service.update(funeralAffilation));
    }

    @DeleteMapping
    public HttpStatus delete(@RequestBody FuneralAffilation funeralAffilation) {
        service.delete(funeralAffilation);

        return HttpStatus.OK;
    }

    @DeleteMapping("/{funeralAffilationId}")
    public HttpStatus
    deleteById(@PathVariable(name = "funeralAffilationId") Long funeralAffilationId) {
        service.deleteById(funeralAffilationId);

        return HttpStatus.OK;
    }
}
