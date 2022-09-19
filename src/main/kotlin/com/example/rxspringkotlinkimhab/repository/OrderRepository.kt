package com.example.rxspringkotlinkimhab.repository

import com.example.rxspringkotlinkimhab.model.entity.Order
import org.reactivestreams.Publisher
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import java.util.*

interface OrderRepository : ReactiveCrudRepository<Order, UUID> {
//    fun findByNameContainingIgnoreCase(name: String): Flux<Order>
//
//    fun findByNameContainingIgnoreCase(name: Publisher<String>): Flux<Order>

//    fun findByNameContainingIgnoreCase(name: Publisher<String>, page: Pageable): Flux<Order>
//    fun findAllOrderByCreatedDateDesc(page: Pageable): Flux<Order>

    @Query("SELECT * FROM orders WHERE name ilike :name")
    fun findByName(name: String): Flux<Order>

    @Query("SELECT id, name, created_date FROM orders WHERE name ilike $1")
    fun findOrderByName(name: String): Flux<Order>
}