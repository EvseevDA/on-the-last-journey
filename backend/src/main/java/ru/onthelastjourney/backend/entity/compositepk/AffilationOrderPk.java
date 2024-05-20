package ru.onthelastjourney.backend.entity.compositepk;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.onthelastjourney.backend.entity.FuneralAffilation;
import ru.onthelastjourney.backend.entity.Order;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class AffilationOrderPk implements Serializable {

    @ManyToOne(
            targetEntity = Order.class,
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(
            targetEntity = FuneralAffilation.class,
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "affilation_id")
    private FuneralAffilation affilation;

}
