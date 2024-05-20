package ru.onthelastjourney.backend.entity.compositepk;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.onthelastjourney.backend.entity.Order;
import ru.onthelastjourney.backend.entity.Service;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class ServiceOrderPk implements Serializable {

    @ManyToOne(
            targetEntity = Order.class,
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(
            targetEntity = Service.class,
            cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "service_id")
    private Service service;

}
