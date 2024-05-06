package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.entity.AffilationType;
import ru.onthelastjourney.backend.repository.AffilationTypeRepository;

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

    public AffilationType getById(Long id) {
        return repository.findById(id).get();
    }

    public AffilationType save(AffilationType affilationType) {
        return repository.save(affilationType);
    }

    public List<AffilationType> saveAll(List<AffilationType> affilationTypes) {
        return repository.saveAll(affilationTypes);
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
