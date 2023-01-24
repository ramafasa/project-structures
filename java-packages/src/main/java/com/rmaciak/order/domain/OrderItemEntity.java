package com.rmaciak.order.domain;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemEntity(UUID id, BigDecimal quota) {

    static OrderItemEntity from(OrderItem orderItem) {
        return new OrderItemEntity(
                orderItem.itemId(),
                orderItem.itemQuota()
        );
    }

    OrderItem toDomain() {
        return new OrderItem(
                id,
                quota
        );
    }
}

