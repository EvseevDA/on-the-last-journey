package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

}
