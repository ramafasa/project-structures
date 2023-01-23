package com.rmaciak.order.api

import com.rmaciak.order.OrderDomainService
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.util.UUID

@RestController
@RequestMapping("/order")
class OrderApi(
        private val orderDomainService: OrderDomainService
) {

    @GetMapping("/{orderId}")
    fun getOrder(@PathVariable orderId: UUID) =
            orderDomainService.getOrder(orderId)

    @PutMapping
    fun createOrder() =
            orderDomainService.createOrder()

    @PostMapping("/{orderId}", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun addItemToOrder(
            @PathVariable orderId: UUID,
            @RequestBody request: AddItemRequest
    ) =
            orderDomainService.addItemToOrder(orderId, request.id, request.quota)


}

data class AddItemRequest(
        val id: UUID,
        val quota: BigDecimal
)