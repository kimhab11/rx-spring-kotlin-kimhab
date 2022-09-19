package com.example.rxspringkotlinkimhab.model.request

import com.example.rxspringkotlinkimhab.model.entity.AppUser

data class AppUserReq(
    val fullname: String
) {
    fun toEntity() = AppUser(
        fullname = fullname
    )
}