package ru.onthelastjourney.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.onthelastjourney.backend.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
