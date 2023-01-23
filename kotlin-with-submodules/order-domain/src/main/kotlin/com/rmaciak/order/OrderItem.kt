package com.rmaciak.order

import java.math.BigDecimal
import java.util.UUID

internal data class OrderItem(
        private val id: UUID,
        private val quota: BigDecimal
) {

    internal fun itemQuota(): BigDecimal = quota

    internal fun toEntity() =
            OrderItemEntity(
                    id = this.id,
                    quota = this.quota
            )

    internal fun toDto() =
            OrderItemDto(
                    id = this.id,
                    quota = this.quota
            )
}