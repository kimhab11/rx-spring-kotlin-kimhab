package com.example.rxspringkotlinkimhab.service
import com.example.rxspringkotlinkimhab.model.dto.OrderDto
import reactor.core.publisher.Flux


interface OrderService {

    fun findAll(): Flux<OrderDto>

//    fun makeOrder(_nameRequest: String): Mono<Order> {
//        val order = Order(name = _nameRequest)
//        return orderRepository.save(order)
//    }
//
//    fun findById(_id: UUID): Mono<Order> {
//        return orderRepository.findById(_id)
//    }
//
//    fun findAll(): Flux<Order> {
//        return orderRepository.findAll()
//    }
}