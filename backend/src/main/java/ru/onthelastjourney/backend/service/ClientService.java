package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.ClientDto;
import ru.onthelastjourney.backend.entity.Client;
import ru.onthelastjourney.backend.repository.ClientRepository;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;
import ru.onthelastjourney.backend.util.exception.ExceptionSupplier;
import ru.onthelastjourney.backend.util.mapper.ClientMapper;

import java.util.List;

@Service
public class ClientService extends AbstractService {

    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> getAll() {
        return repository.findAll();
    }

    public Client getById(Long id) throws EntityNotFoundException {
        return repository.findById(id).orElseThrow(ExceptionSupplier.clientNotFoundById(id));
    }

    public Client save(ClientDto dto) {
        return repository.save(ClientMapper.fromDto(dto));
    }

    public List<Client> saveAll(List<ClientDto> dtos) {
        return repository.saveAll(ClientMapper.fromDto(dtos));
    }

    public Client update(Client client) {
        return repository.save(client);
    }

    public void delete(Client client) {
        repository.delete(client);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
