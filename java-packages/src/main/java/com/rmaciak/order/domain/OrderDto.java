package com.rmaciak.order.domain;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

public record OrderDto(UUID id, BigDecimal quota, Set<OrderItemDto> items) {

    static OrderDto from(Order order) {
        return new OrderDto(
                order.orderId(),
                order.orderQuota(),
                order.orderItems().stream().map(OrderItemDto::from).collect(toSet())
        );
    }
}

