package com.example.rxspringkotlinkimhab.model.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID


data class OrderDto(
    val id: UUID,
    val name: String,
    @JsonFormat(pattern = "yyyy-MM-dd, HH:mm:ss")
    val createdAt: LocalDateTime,
    var appUser: AppUserDto? = null
)
