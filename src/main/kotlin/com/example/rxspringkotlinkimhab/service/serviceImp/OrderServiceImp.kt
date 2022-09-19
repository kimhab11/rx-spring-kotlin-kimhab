package com.example.rxspringkotlinkimhab.service.serviceImp

import com.example.rxspringkotlinkimhab.model.dto.OrderDto
import com.example.rxspringkotlinkimhab.repository.AppUserRepository
import com.example.rxspringkotlinkimhab.repository.OrderRepository
import com.example.rxspringkotlinkimhab.service.OrderService
import org.springframework.data.domain.jaxb.SpringDataJaxb
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class OrderServiceImp(val orderRepository: OrderRepository, val appUserRepository: AppUserRepository) : OrderService {
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
}