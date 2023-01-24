package com.rmaciak.order.domain;

import java.util.UUID;

public interface OrderEntityPersistence {
    OrderEntity getOrder(UUID orderId);
    OrderEntity save(OrderEntity order);
}
