package ru.onthelastjourney.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import ru.onthelastjourney.backend.entity.compositepk.AffilationOrderPk;

import java.math.BigDecimal;

@Entity
@Table(name = "affilations_orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class AffilationOrder {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private AffilationOrderPk pk;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "affilation_count")
    private Long affilationCount;

    @Column(name = "percent_discount")
    private Long percentDiscount;

}
