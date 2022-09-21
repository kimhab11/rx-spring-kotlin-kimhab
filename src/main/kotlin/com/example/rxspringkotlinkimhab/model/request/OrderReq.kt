package com.example.rxspringkotlinkimhab.model.request

import com.example.rxspringkotlinkimhab.model.entity.Order
import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID

data class OrderReq(
    val name: String,
    val userId: UUID
)
{
    fun toEntity() = Order(
        name = name,
        createdAt = LocalDateTime.now(),
        userId = userId
    )
}
