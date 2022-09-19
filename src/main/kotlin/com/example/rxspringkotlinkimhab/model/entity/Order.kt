package com.example.rxspringkotlinkimhab.model.entity


import com.example.rxspringkotlinkimhab.model.dto.OrderDto
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.*

@Table("orders")
data class Order(

    @Id
    @Column("id")
    val id: Long? = null,

    @Column("name")
    val name: String,

    @Column("created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column("user_id")
    val userId: Long
) {
    fun toDto() = OrderDto(
        id = id!!,
        name = name,
        createdAt = createdAt,
        appUser = null
    )
}