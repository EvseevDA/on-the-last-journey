package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.Employee;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(
            value = "SELECT * " +
                    "FROM funeralservice.employee e " +
                    "WHERE e.id = (SELECT boss_id FROM funeralservice.employees e WHERE e.id = :id)",
            nativeQuery = true
    )
    Optional<Employee> findEmployeeBossByEmployeeId(@Param("id") Long id);

}
