package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.AffilationType;

@Repository
public interface AffilationTypeRepository extends JpaRepository<AffilationType, Long> {

}
