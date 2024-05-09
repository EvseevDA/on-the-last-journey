package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.ServiceOrder;
import ru.onthelastjourney.backend.entity.compositepk.ServiceOrderPk;

import java.util.List;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, ServiceOrderPk> {

    @Query(
            value = "SELECT * FROM funeralservice.services_orders WHERE order_id = ?",
            nativeQuery = true
    )
    List<ServiceOrder> findAllWhereOrderIdIs(Long id);

}
