package com.example.rxspringkotlinkimhab.service.serviceImp

import com.example.rxspringkotlinkimhab.model.dto.OrderDto
import com.example.rxspringkotlinkimhab.model.request.OrderReq
import com.example.rxspringkotlinkimhab.repository.AppUserRepository
import com.example.rxspringkotlinkimhab.repository.OrderRepository
import com.example.rxspringkotlinkimhab.service.OrderService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class OrderServiceImp(
    val orderRepository: OrderRepository,
    val appUserRepository: AppUserRepository)
    : OrderService {
    override fun findAll(): Flux<OrderDto> {
        val ordersMono = orderRepository
            .findAll()
        val appUserMono = ordersMono
            .flatMap {
                appUserRepository.findById(it.userId)
            }

        return ordersMono.zipWith(appUserMono)
            .map {
                val order = it.t1
                val user = it.t2

                val orderRespone = order.toDto()

                orderRespone.appUser = user.toDto()

                orderRespone

            }
    }

    override fun addOrder(orderReq: OrderReq): Mono<OrderDto> {
        val appUserDto = appUserRepository.findById(orderReq.userId).map { it.toDto() }

        val orderDto = orderRepository.save(orderReq.toEntity()).map { it.toDto() }

        val result = orderDto.zipWith(appUserDto)
            .map {
                val order = it.t1
                val user = it.t2
                order.appUser=user
                return@map order
            }
        return result
    }
}