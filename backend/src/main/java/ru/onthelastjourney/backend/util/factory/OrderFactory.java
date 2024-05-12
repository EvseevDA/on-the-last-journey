package ru.onthelastjourney.backend.util.factory;

import ru.onthelastjourney.backend.entity.Order;

public class OrderFactory {

    OrderFactory() {
    }

    public static Order createOrderById(Long id) {
        return Order.builder().id(id).build();
    }

}
