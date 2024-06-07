package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    Optional<User> findByLoginAndPassword(String login, String password);

    boolean existsByLoginAndPassword(String login, String password);

}
