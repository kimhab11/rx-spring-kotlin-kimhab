package com.example.rxspringkotlinkimhab.model.dto

import java.time.LocalDateTime


data class OrderDto(
    val id: Long,
    val name: String,
    val createdAt: LocalDateTime,
    var appUser: AppUserDto? = null
)
