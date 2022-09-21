package com.example.rxspringkotlinkimhab.handler
import com.example.rxspringkotlinkimhab.model.dto.OrderDto
import com.example.rxspringkotlinkimhab.model.request.OrderReq
import com.example.rxspringkotlinkimhab.service.OrderService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class OrderHandler(val orderService: OrderService)  {
    fun findAll(request: ServerRequest): Mono<ServerResponse>{
        val orderAll = orderService.findAll()
        return ServerResponse
            .ok()
            .body(orderAll, OrderDto::class.java)
    }
    fun addOrder(request: ServerRequest): Mono<ServerResponse>{
        val orderReqMono = request.bodyToMono(OrderReq::class.java)
        val result: Mono<OrderDto> = orderReqMono.flatMap {
            orderService.addOrder(it)
        }
        return ServerResponse
            .ok()
            .body(result, OrderDto::class.java)
    }
}