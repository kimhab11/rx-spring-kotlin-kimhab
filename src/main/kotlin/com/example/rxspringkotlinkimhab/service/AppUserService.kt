package com.example.rxspringkotlinkimhab.service

import com.example.rxspringkotlinkimhab.model.dto.AppUserDto
import com.example.rxspringkotlinkimhab.model.request.AppUserReq
import org.springframework.web.bind.annotation.PathVariable
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID


interface AppUserService {
    fun findAll(): Flux<AppUserDto>
    fun findById(id: UUID): Mono<AppUserDto>
    fun save(appUser: AppUserReq): Mono<AppUserDto>
}