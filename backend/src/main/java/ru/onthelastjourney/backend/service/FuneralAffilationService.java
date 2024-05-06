package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.FuneralAffilationDto;
import ru.onthelastjourney.backend.entity.FuneralAffilation;
import ru.onthelastjourney.backend.mapper.FuneralAffilationMapper;
import ru.onthelastjourney.backend.repository.FuneralAffilationRepository;

import java.util.List;

@Service
public class FuneralAffilationService {

    private final FuneralAffilationRepository repository;

    @Autowired
    public FuneralAffilationService(FuneralAffilationRepository repository) {
        this.repository = repository;
    }

    public List<FuneralAffilation> getAll() {
        return repository.findAll();
    }

    public FuneralAffilation getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public FuneralAffilation save(FuneralAffilationDto dto) {
        return repository.save(FuneralAffilationMapper.fromDto(dto));
    }

    public List<FuneralAffilation> saveAll(List<FuneralAffilationDto> dtos) {
        return repository.saveAll(FuneralAffilationMapper.fromDto(dtos));
    }

    public FuneralAffilation update(FuneralAffilation funeralAffilation) {
        return repository.save(funeralAffilation);
    }

    public void delete(FuneralAffilation funeralAffilation) {
        repository.delete(funeralAffilation);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
