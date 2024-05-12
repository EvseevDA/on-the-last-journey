package ru.onthelastjourney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.onthelastjourney.backend.dto.EmployeeDto;
import ru.onthelastjourney.backend.entity.Employee;
import ru.onthelastjourney.backend.service.EmployeeService;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee>
    getById(@PathVariable(name = "employeeId") Long employeeId) throws EntityNotFoundException {
        return ResponseEntity.ok(service.getById(employeeId));
    }

    @GetMapping("/{employeeId}/boss")
    public ResponseEntity<EmployeeDto>
    getEmployeeBossByEmployeeId(@PathVariable(name = "employeeId") Long employeeId) throws EntityNotFoundException {
        return ResponseEntity.ok(service.getEmployeeBossByEmployeeId(employeeId));
    }

    @PostMapping
    public ResponseEntity<Employee>
    save(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(service.save(employeeDto));
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<Employee>>
    saveAll(@RequestBody List<EmployeeDto> employeeDtos) {
        return ResponseEntity.ok(service.saveAll(employeeDtos));
    }

    @PutMapping
    public ResponseEntity<Employee>
    update(@RequestBody Employee employee) {
        return ResponseEntity.ok(service.update(employee));
    }

    @DeleteMapping
    public HttpStatus delete(@RequestBody Employee employee) {
        service.delete(employee);

        return HttpStatus.OK;
    }

    @DeleteMapping("/{employeeId}")
    public HttpStatus deleteById(@PathVariable(name = "employeeId") Long employeeId) {
        service.deleteById(employeeId);

        return HttpStatus.OK;
    }
}
