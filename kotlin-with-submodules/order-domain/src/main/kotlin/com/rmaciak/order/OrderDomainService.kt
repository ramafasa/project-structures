package com.rmaciak.order

import java.math.BigDecimal
import java.util.UUID


class OrderDomainService(
        private val orderRepository: OrderRepository
) {

    fun getOrder(orderId: UUID): OrderDto =
            orderRepository.getOrder(orderId)?.toDto()
                    ?: throw OrderNotExistsException()

    fun createOrder(): OrderDto =
            orderRepository.saveOrder(
                    Order.create()
            ).toDto()

    fun addItemToOrder(orderId: UUID, itemId: UUID, itemQuota: BigDecimal): OrderDto =
            orderRepository
                    .getOrder(orderId)
                    ?.addItem(
                            OrderItem(itemId, itemQuota)
                    )
                    ?.let { orderRepository.saveOrder(it) }
                    ?.toDto()
                    ?: throw OrderNotExistsException()
}

data class OrderDto(
        val id: UUID,
        val quota: BigDecimal,
        val items: Set<OrderItemDto>
)

data class OrderItemDto(
        val id: UUID,
        val quota: BigDecimal
)

class OrderNotExistsException : RuntimeException()