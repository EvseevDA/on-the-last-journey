package ru.onthelastjourney.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.onthelastjourney.backend.dto.UserDto;
import ru.onthelastjourney.backend.entity.User;
import ru.onthelastjourney.backend.repository.UserRepository;
import ru.onthelastjourney.backend.util.encoder.Encoder;
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

    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<User> getByLogin(String login) {
        return repository.findByLogin(login);
    }

    public Optional<User> getByLoginAndPassword(String login, String password) {
        String encodedPassword = encoder.encode(password);
        return repository.findByLoginAndPassword(login, encodedPassword);
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
