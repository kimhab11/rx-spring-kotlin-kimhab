package com.example.rxspringkotlinkimhab.model.entity

import com.example.rxspringkotlinkimhab.model.dto.AppUserDto
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("app_users")
data class AppUser(

    @Id
    @Column("id")
    val id: Long? = null,

    @Column("fullname")
    val fullname: String
) {
    fun toDto() = AppUserDto(
        id = id!! , // !! can null
        fullname = fullname
    )
}