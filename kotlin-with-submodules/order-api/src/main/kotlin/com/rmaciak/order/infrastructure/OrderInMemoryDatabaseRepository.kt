package com.rmaciak.order.infrastructure

import com.rmaciak.order.OrderEntity
import com.rmaciak.order.OrderPersistance
import java.util.UUID

class OrderInMemoryDatabaseRepository(
        private val database: MutableSet<OrderEntity> = mutableSetOf()
): OrderPersistance {

    override fun getOrderEntity(orderId: UUID): OrderEntity? =
            database.find { it.id == orderId }

    override fun saveOrder(order: OrderEntity): OrderEntity {
        database.add(order)
        return order
    }
}