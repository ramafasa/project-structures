package com.rmaciak.order.domain;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

public record OrderEntity(UUID id, BigDecimal quota, Set<OrderItemEntity> items) {

    static OrderEntity from(Order order) {
        return new OrderEntity(
                order.orderId(),
                order.orderQuota(),
                order.orderItems().stream().map(OrderItemEntity::from).collect(toSet())
        );
    }

    Order toDomain() {
        return new Order(
                id,
                quota,
                items.stream().map(OrderItemEntity::toDomain).collect(toSet())
        );
    }
}

