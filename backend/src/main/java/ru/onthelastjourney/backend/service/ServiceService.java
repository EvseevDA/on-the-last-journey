package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.onthelastjourney.backend.dto.ServiceDto;
import ru.onthelastjourney.backend.entity.Service;
import ru.onthelastjourney.backend.repository.ServiceRepository;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;
import ru.onthelastjourney.backend.util.exception.ExceptionSupplier;
import ru.onthelastjourney.backend.util.mapper.ServiceMapper;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService extends AbstractService {

    private final ServiceRepository repository;

    @Autowired
    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public List<Service> getAll() {
        return repository.findAll();
    }

    public Service getById(Long id) throws EntityNotFoundException {
        return repository.findById(id).orElseThrow(ExceptionSupplier.serviceNotFoundById(id));
    }

    public Service save(ServiceDto dto) {
        return repository.save(ServiceMapper.fromDto(dto));
    }

    public List<Service> saveAll(List<ServiceDto> dtos) {
        return repository.saveAll(ServiceMapper.fromDto(dtos));
    }

    public Service update(Service service) {
        return repository.save(service);
    }

    public void delete(Service service) {
        repository.delete(service);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
