package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(
            value = "SELECT * FROM funeralservice.employees e WHERE e.id = (SELECT boss_id FROM funeralservice.employees e WHERE e.id = ?)",
            nativeQuery = true
    )
    Employee getEmployeeBossByEmployeeId(Long employeeId);
    
}
