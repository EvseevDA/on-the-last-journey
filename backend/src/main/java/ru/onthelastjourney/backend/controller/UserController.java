package ru.onthelastjourney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.onthelastjourney.backend.dto.UserDto;
import ru.onthelastjourney.backend.entity.User;
import ru.onthelastjourney.backend.service.UserService;
import ru.onthelastjourney.backend.util.exception.EntityNotFoundException;
import ru.onthelastjourney.backend.util.exception.ExceptionSupplier;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable("userId") Long userId) throws EntityNotFoundException {
        return ResponseEntity.ok(service.getById(userId));
    }

    @GetMapping("/by-login/{login}")
    public ResponseEntity<User> getByLogin(@PathVariable("login") String login) throws EntityNotFoundException {
        return ResponseEntity.ok(service.getByLogin(login));
    }

    @GetMapping("/{login}/{password}")
    public ResponseEntity<User>
    getByLoginAndPassword(@PathVariable("login") String login,
                          @PathVariable("password") String password) throws EntityNotFoundException {
        return ResponseEntity.ok(
                service.getByLoginAndPassword(login, password)
        );
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.save(userDto));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(service.update(user));
    }

    @GetMapping("/exists/{login}/{password}")
    public ResponseEntity<Boolean> existsByLoginAndPassword(@PathVariable("login") String login,
                                                            @PathVariable("password") String password) {
        return ResponseEntity.ok(service.existsByLoginAndPassword(login, password));
    }

    @DeleteMapping
    public HttpStatus delete(@RequestBody User user) {
        service.delete(user);

        return HttpStatus.OK;
    }

    @DeleteMapping("/{userId}")
    public HttpStatus deleteById(@PathVariable("userId") Long userId) {
        service.deleteById(userId);

        return HttpStatus.OK;
    }

}
