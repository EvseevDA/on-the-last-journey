package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.OrderEmployee;
import ru.onthelastjourney.backend.entity.compositepk.OrderEmployeePk;

import java.util.List;

@Repository
public interface OrderEmployeeRepository extends JpaRepository<OrderEmployee, OrderEmployeePk> {

    @Query(
            value = "SELECT * FROM funeralservice.orders_employees WHERE order_id = :id",
            nativeQuery = true
    )
    List<OrderEmployee> findAllByOrderId(@Param("id") Long id);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(
            value = "INSERT INTO " +
                    "funeralservice.orders_employees (order_id, employee_id) " +
                    "VALUES (:orderId, :employeeId)",
            nativeQuery = true
    )
    void saveByDbFields(@Param("orderId") Long orderId, @Param("employeeId") Long employeeId);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(
            value = "DELETE FROM funeralservice.orders_employees WHERE order_id = :orderId AND employee_id = :employeeId",
            nativeQuery = true
    )
    void deleteByDbFields(@Param("orderId") Long orderId, @Param("employeeId") Long employeeId);

}
