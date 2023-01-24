package com.rmaciak.order.intrastructure;

import com.rmaciak.order.domain.OrderEntity;
import com.rmaciak.order.domain.OrderEntityPersistence;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
public class OrderInMemoryRepository implements OrderEntityPersistence {

    private final Set<OrderEntity> orders = new HashSet<>();

    @Override
    public OrderEntity getOrder(UUID orderId) {
        return orders.stream()
                .filter(it -> it.id().equals(orderId))
                .findFirst()
                .orElseThrow(OrderNotExistsException::new);
    }

    @Override
    public OrderEntity save(OrderEntity order) {
        orders.add(order);
        return order;
    }
}

class OrderNotExistsException extends RuntimeException {

}
