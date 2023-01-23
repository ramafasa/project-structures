package com.rmaciak.order

import java.util.UUID

interface OrderPersistance {
    fun getOrderEntity(orderId: UUID): OrderEntity?
    fun saveOrder(order: OrderEntity): OrderEntity
}

class OrderRepository(
        private val orderPersistance: OrderPersistance
) {

    internal fun getOrder(orderId: UUID): Order? =
            orderPersistance.getOrderEntity(orderId)?.toDomain()

    internal fun saveOrder(order: Order): Order =
            orderPersistance.saveOrder(order.toEntity()).toDomain()
}

private fun OrderEntity.toDomain() =
        Order(
                id = this.id,
                quota = this.quota,
                items = this.items.map { it.toDomain() }.toSet()
        )

private fun OrderItemEntity.toDomain() =
        OrderItem(
                id = this.id,
                quota = this.quota
        )

