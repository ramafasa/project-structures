package com.rmaciak.order.domain;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemDto(UUID id, BigDecimal quota) {

    static OrderItemDto from(OrderItem orderItem) {
        return new OrderItemDto(
                orderItem.itemId(),
                orderItem.itemQuota()
        );
    }
}
