package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.AffilationOrder;
import ru.onthelastjourney.backend.entity.compositepk.AffilationOrderPk;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AffilationOrderRepository extends JpaRepository<AffilationOrder, AffilationOrderPk> {

    @Query(
            value = "SELECT * FROM funeralservice.affilations_orders WHERE order_id = :id",
            nativeQuery = true
    )
    List<AffilationOrder> findAllByOrderId(@Param("id") Long id);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(
            value = "INSERT INTO " +
                    "funeralservice.affilations_orders (order_id, affilation_id, price, affilation_count, percent_discount) " +
                    "VALUES (:orderId, :affilationId, :price, :affilationCount, :percentDiscount)",
            nativeQuery = true
    )
    void saveByDbFields(@Param("orderId") Long orderId,
                        @Param("affilationId") Long affilationId,
                        @Param("price") BigDecimal price,
                        @Param("affilationCount") Long affilationCount,
                        @Param("percentDiscount") Long percentDiscount);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(
            value = "UPDATE funeralservice.affilations_orders " +
                    "SET price = :price, affilation_count = :affilationCount, percent_discount = :percentDiscount " +
                    "WHERE order_id = :orderId AND affilation_id = :affilationId",
            nativeQuery = true
    )
    void updateByDbFields(@Param("orderId") Long orderId,
                          @Param("affilationId") Long affilationId,
                          @Param("price") BigDecimal price,
                          @Param("affilationCount") Long affilationCount,
                          @Param("percentDiscount") Long percentDiscount);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(
            value = "DELETE FROM funeralservice.affilations_orders WHERE order_id = :orderId AND affilation_id = :affilationId",
            nativeQuery = true
    )
    void deleteByDbFields(@Param("orderId") Long orderId, @Param("affilationId") Long affilationId);

}
