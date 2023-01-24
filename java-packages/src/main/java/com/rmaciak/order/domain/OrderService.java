package com.rmaciak.order.domain;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto createOrder() {
        return OrderDto.from(
                orderRepository.save(
                        Order.createOrder()
                )
        );
    }

    public OrderDto addItemToOrder(UUID orderId, UUID itemId, BigDecimal itemQuota) {
        var order = orderRepository
                .getOrder(orderId)
                .addItem(
                        new OrderItem(itemId, itemQuota)
                );

        return OrderDto.from(
            orderRepository.save(order)
        );
    }

    public OrderDto getOrder(UUID orderId) {
        return OrderDto.from(
                orderRepository.getOrder(orderId)
        );
    }
}
