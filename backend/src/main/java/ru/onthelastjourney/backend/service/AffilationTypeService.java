package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.AffilationTypeDto;
import ru.onthelastjourney.backend.entity.AffilationType;
import ru.onthelastjourney.backend.repository.AffilationTypeRepository;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;
import ru.onthelastjourney.backend.util.exception.ExceptionSupplier;
import ru.onthelastjourney.backend.util.mapper.AffilationTypeMapper;

import java.util.List;

@Service
public class AffilationTypeService {

    private final AffilationTypeRepository repository;

    @Autowired
    public AffilationTypeService(AffilationTypeRepository repository) {
        this.repository = repository;
    }

    public List<AffilationType> getAll() {
        return repository.findAll();
    }

    public AffilationType getById(Long id) throws EntityNotFoundException {
        return repository.findById(id).orElseThrow(ExceptionSupplier.affilationTypeNotFoundById(id));
    }

    public AffilationType save(AffilationTypeDto dto) {
        return repository.save(AffilationTypeMapper.fromDto(dto));
    }

    public List<AffilationType> saveAll(List<AffilationTypeDto> dtos) {
        return repository.saveAll(AffilationTypeMapper.fromDto(dtos));
    }

    public AffilationType update(AffilationType affilationType) {
        return repository.save(affilationType);
    }

    public void delete(AffilationType affilationType) {
        repository.delete(affilationType);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
