package com.rmaciak.order.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

final class Order {

    private final UUID id;
    private final BigDecimal quota;
    private final Set<OrderItem> items;

    Order(UUID id, BigDecimal quota, Set<OrderItem> items) {
        this.id = id;
        this.quota = quota;
        this.items = items;
    }

    static Order createOrder() {
        return new Order(
                UUID.randomUUID(),
                BigDecimal.ZERO,
                Set.of()
        );
    }

    Order addItem(OrderItem orderItem) {
        Set<OrderItem> newItems = new HashSet<>(this.items);
        newItems.add(orderItem);

        return new Order(
                id,
                this.quota.add(orderItem.itemQuota()),
                newItems
        );
    }

    UUID orderId() {
        return id;
    }

    BigDecimal orderQuota() {
        return quota;
    }

    Set<OrderItem> orderItems() {
        return items;
    }
}
