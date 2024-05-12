package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.EmployeeDto;
import ru.onthelastjourney.backend.entity.Employee;
import ru.onthelastjourney.backend.repository.EmployeeRepository;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;
import ru.onthelastjourney.backend.util.exception.ExceptionSupplier;
import ru.onthelastjourney.backend.util.mapper.EmployeeMapper;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Long id) throws EntityNotFoundException {
        return repository.findById(id).orElseThrow(ExceptionSupplier.employeeNotFoundById(id));
    }

    public EmployeeDto getEmployeeBossByEmployeeId(Long id) throws EntityNotFoundException {
        return EmployeeMapper
                .toDto(
                        repository.getEmployeeBossByEmployeeId(id).orElseThrow(ExceptionSupplier.employeeNotFoundById(id))
                );
    }

    public Employee save(EmployeeDto employeeDto) {
        return repository.save(EmployeeMapper.fromDto(employeeDto));
    }

    public List<Employee> saveAll(List<EmployeeDto> dtos) {
        return repository.saveAll(EmployeeMapper.fromDto(dtos));
    }

    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    public void delete(Employee employee) {
        repository.delete(employee);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
