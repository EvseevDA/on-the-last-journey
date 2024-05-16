package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.ServiceOrder;
import ru.onthelastjourney.backend.entity.compositepk.ServiceOrderPk;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, ServiceOrderPk> {

    @Query(
            value = "SELECT * FROM funeralservice.services_orders WHERE order_id = :id",
            nativeQuery = true
    )
    List<ServiceOrder> findAllByOrderId(@Param("id") Long id);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(
            value = "INSERT INTO " +
                    "funeralservice.services_orders (order_id, service_id, price, percent_discount) " +
                    "VALUES (:orderId, :serviceId, :price, :percentDiscount)",
            nativeQuery = true
    )
    void saveByDbFields(@Param("orderId") Long orderId,
                        @Param("serviceId") Long serviceId,
                        @Param("price") BigDecimal price,
                        @Param("percentDiscount") Long percentDiscount);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(
            value = "UPDATE funeralservice.services_orders " +
                    "SET price = :price, percent_discount = :percentDiscount " +
                    "WHERE order_id = :orderId AND service_id = :serviceId",
            nativeQuery = true
    )
    void updateByDbFields(@Param("orderId") Long orderId,
                          @Param("serviceId") Long serviceId,
                          @Param("price") BigDecimal price,
                          @Param("percentDiscount") Long percentDiscount);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(
            value = "DELETE FROM funeralservice.services_orders WHERE order_id = :orderId AND service_id = :serviceId",
            nativeQuery = true
    )
    void deleteByOrderIdAndServiceId(@Param("orderId") Long orderId, @Param("serviceId") Long serviceId);

}
