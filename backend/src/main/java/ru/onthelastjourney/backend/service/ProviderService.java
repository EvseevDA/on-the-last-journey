package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.ProviderDto;
import ru.onthelastjourney.backend.entity.Provider;
import ru.onthelastjourney.backend.mapper.ProviderMapper;
import ru.onthelastjourney.backend.repository.ProviderRepository;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository repository;

    @Autowired
    public ProviderService(ProviderRepository repository) {
        this.repository = repository;
    }

    public List<Provider> getAll() {
        return repository.findAll();
    }

    public Provider getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Provider save(ProviderDto dto) {
        return repository.save(ProviderMapper.fromDto(dto));
    }

    public List<Provider> saveAll(List<ProviderDto> dtos) {
        return repository.saveAll(ProviderMapper.fromDto(dtos));
    }

    public Provider update(Provider provider) {
        return repository.save(provider);
    }

    public void delete(Provider provider) {
        repository.delete(provider);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
