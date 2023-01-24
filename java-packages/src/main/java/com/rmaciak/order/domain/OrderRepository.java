package com.rmaciak.order.domain;

import org.springframework.stereotype.Repository;

import java.util.UUID;

import static com.rmaciak.order.domain.OrderEntity.from;

@Repository
class OrderRepository {

    private final OrderEntityPersistence orderPersistence;

    OrderRepository(OrderEntityPersistence orderPersistence) {
        this.orderPersistence = orderPersistence;
    }

    Order getOrder(UUID orderId) {
        return orderPersistence.getOrder(orderId).toDomain();
    }

    Order save(Order order) {
        return orderPersistence.save(from(order)).toDomain();
    }
}

