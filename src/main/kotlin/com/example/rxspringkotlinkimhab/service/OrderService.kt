package com.example.rxspringkotlinkimhab.service
import com.example.rxspringkotlinkimhab.model.dto.OrderDto
import com.example.rxspringkotlinkimhab.model.request.OrderReq
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface OrderService {

    fun findAll(): Flux<OrderDto>
//
//    fun findById(_id: UUID): Mono<Order> {
//        return orderRepository.findById(_id)
//    }
//
    fun addOrder(orderReq: OrderReq): Mono<OrderDto>
}