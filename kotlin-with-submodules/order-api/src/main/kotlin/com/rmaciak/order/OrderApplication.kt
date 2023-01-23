package com.rmaciak.order

import com.rmaciak.order.infrastructure.OrderInMemoryDatabaseRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class OrderApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(OrderApplication::class.java, *args)
        }
    }

    @Bean
    fun orderPersistence() =
            OrderInMemoryDatabaseRepository()

    @Bean
    fun orderRepository(orderPersistence: OrderPersistance) =
            OrderRepository(orderPersistence)

    @Bean
    fun orderDomainService(orderRepository: OrderRepository) =
            OrderDomainService(orderRepository)
}