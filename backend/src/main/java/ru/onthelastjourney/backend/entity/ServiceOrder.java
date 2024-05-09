package ru.onthelastjourney.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import ru.onthelastjourney.backend.entity.compositepk.ServiceOrderPk;

import java.math.BigDecimal;

@Entity
@Table(name = "services_orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class ServiceOrder {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private ServiceOrderPk pk;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "percent_discount")
    private Long percentDiscount;

}
