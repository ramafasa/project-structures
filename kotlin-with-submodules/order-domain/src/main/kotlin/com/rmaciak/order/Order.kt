package com.rmaciak.order

import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.util.UUID

internal data class Order(
        private val id: UUID,
        private val quota: BigDecimal,
        private val items: Set<OrderItem>
) {

    internal fun addItem(item: OrderItem) =
            this.copy(
                    quota = this.quota.add(item.itemQuota()),
                    items = items + item
            )

    companion object {
        fun create() = Order(UUID.randomUUID(), ZERO, emptySet())
    }

    internal fun toEntity() =
            OrderEntity(
                    id = this.id,
                    quota = this.quota,
                    items = this.items.map { it.toEntity() }.toSet()
            )

    internal fun toDto() =
            OrderDto(
                    id = this.id,
                    quota = this.quota,
                    items = this.items.map { it.toDto() }.toSet()
            )
}