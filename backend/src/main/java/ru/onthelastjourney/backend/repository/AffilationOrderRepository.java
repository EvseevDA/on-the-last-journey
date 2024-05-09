package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.AffilationOrder;
import ru.onthelastjourney.backend.entity.compositepk.AffilationOrderPk;

import java.util.List;

@Repository
public interface AffilationOrderRepository extends JpaRepository<AffilationOrder, AffilationOrderPk> {

    @Query(
            value = "SELECT * FROM funeralservice.affilations_orders WHERE order_id = ?",
            nativeQuery = true
    )
    List<AffilationOrder> findAllWhereOrderIdIs(Long id);

}
