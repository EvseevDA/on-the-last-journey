package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.compositepk.OrderEmployeePk;
import ru.onthelastjourney.backend.entity.OrderEmployee;

import java.util.List;

@Repository
public interface OrderEmployeeRepository extends JpaRepository<OrderEmployee, OrderEmployeePk> {

    @Query(
            value = "SELECT * FROM funeralservice.orders_employees WHERE order_id = ?",
            nativeQuery = true
    )
    List<OrderEmployee> findAllWhereOrderIdIs(Long id);

}
