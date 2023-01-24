package com.rmaciak.order.api;


import com.rmaciak.order.domain.OrderDto;
import com.rmaciak.order.domain.OrderService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/order")
public class OrderHttpApi {

    private final OrderService orderService;

    public OrderHttpApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/{orderId}", produces = {APPLICATION_JSON_VALUE})
    public OrderDto getOrder(@PathVariable UUID orderId) {
        return orderService.getOrder(orderId);
    }

    @PutMapping(produces = {APPLICATION_JSON_VALUE})
    public OrderDto createOrder() {
        return orderService.createOrder();
    }

    @PostMapping(path = "/{orderId}", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
    public OrderDto addItemToOrder(
            @PathVariable UUID orderId,
            @RequestBody AddItemToOrderRequest request
    ) {
        return orderService.addItemToOrder(orderId, request.itemId, request.quota);
    }

    record AddItemToOrderRequest(
            UUID itemId,
            BigDecimal quota
    ) {

    }
}
