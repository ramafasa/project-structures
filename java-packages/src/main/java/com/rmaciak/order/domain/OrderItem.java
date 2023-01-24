package com.rmaciak.order.domain;

import java.math.BigDecimal;
import java.util.UUID;

final class OrderItem {

    OrderItem(UUID id, BigDecimal quota) {
        this.id = id;
        this.quota = quota;
    }

    private final UUID id;
    private final BigDecimal quota;

    BigDecimal itemQuota() {
        return quota;
    }

    UUID itemId() {
        return id;
    }
}
