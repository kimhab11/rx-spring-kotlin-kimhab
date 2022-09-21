package com.example.rxspringkotlinkimhab.model.dto

import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID

data class AppUserDto(
    val id: UUID,
    val fullname: String) {
}
