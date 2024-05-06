package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}
