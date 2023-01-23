package com.rmaciak.order

import java.math.BigDecimal
import java.util.UUID

data class OrderEntity(
        val id: UUID,
        val quota: BigDecimal,
        val items: Set<OrderItemEntity>
)

data class OrderItemEntity(
        val id: UUID,
        val quota: BigDecimal
)
