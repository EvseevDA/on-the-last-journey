package ru.onthelastjourney.backend.entity.compositepk;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.onthelastjourney.backend.entity.Employee;
import ru.onthelastjourney.backend.entity.Order;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class OrderEmployeePk implements Serializable {

    @ManyToOne(
            targetEntity = Order.class,
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(
            targetEntity = Employee.class,
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
