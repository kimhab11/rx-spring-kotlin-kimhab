package com.example.rxspringkotlinkimhab.model.entity


import com.example.rxspringkotlinkimhab.model.dto.OrderDto
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*

@Table("orders")
data class Order(

    @Id
    @Column("id")
    val id: UUID? = null,

    @Column("name")
    val name: String,

    @Column("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime,

    @Column("user_id")
    val userId: UUID
) {
    fun toDto() = OrderDto(
        id = id!!,
        name = name,
        createdAt = createdAt,
        appUser = null
    )
}