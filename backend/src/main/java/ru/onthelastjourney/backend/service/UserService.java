package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.UserDto;
import ru.onthelastjourney.backend.entity.User;
import ru.onthelastjourney.backend.repository.UserRepository;
import ru.onthelastjourney.backend.util.encoder.Encoder;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;
import ru.onthelastjourney.backend.util.exception.ExceptionSupplier;
import ru.onthelastjourney.backend.util.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends AbstractService {

    private final UserRepository repository;

    private final Encoder encoder;

    @Autowired
    public UserService(UserRepository repository, Encoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) throws EntityNotFoundException {
        return repository.findById(id).orElseThrow(ExceptionSupplier.userNotFoundById(id));
    }

    public User getByLogin(String login) throws EntityNotFoundException {
        return repository.findByLogin(login).orElseThrow(ExceptionSupplier.userNotFoundByLogin(login));
    }

    public User getByLoginAndPassword(String login, String password) throws EntityNotFoundException {
        String encodedPassword = encoder.encode(password);
        return repository.findByLoginAndPassword(login, encodedPassword)
                .orElseThrow(ExceptionSupplier.userNotFoundByLoginAndPassword(login, password));
    }

    public User save(UserDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        return repository.save(UserMapper.fromDto(dto));
    }

    public User update(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public boolean existsByLoginAndPassword(String login, String password) {
        String encodedPassword = encoder.encode(password);
        return repository.existsByLoginAndPassword(login, encodedPassword);
    }

    public void delete(User user) {
        repository.delete(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
