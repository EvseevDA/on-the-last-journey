package ru.onthelastjourney.backend.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import ru.onthelastjourney.backend.entity.compositepk.OrderEmployeePk;

@Entity
@Table(name = "orders_employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class OrderEmployee {

    @EmbeddedId
    private OrderEmployeePk orderEmployeePk;

}
