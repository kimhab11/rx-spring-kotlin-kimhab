package com.example.rxspringkotlinkimhab.model.request

import com.example.rxspringkotlinkimhab.model.entity.Order
import java.time.LocalDateTime

data class OrderReq(
    val name: String,
    val userId: Long
)
{
    fun toEntity() = Order(
        name = name,
        createdAt = LocalDateTime.now(),
        userId = userId
    )
}
