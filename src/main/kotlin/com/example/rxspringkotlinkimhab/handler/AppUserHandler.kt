package com.example.rxspringkotlinkimhab.handler

import com.example.rxspringkotlinkimhab.model.dto.AppUserDto
import com.example.rxspringkotlinkimhab.model.entity.AppUser
import com.example.rxspringkotlinkimhab.model.request.AppUserReq
import com.example.rxspringkotlinkimhab.service.AppUserService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.util.UUID

@Component
class AppUserHandler(val appUserService: AppUserService) {
    fun findAll(request: ServerRequest): Mono<ServerResponse> {
        val allUser = appUserService.findAll()
        return ServerResponse
            .ok()
            .body(allUser , AppUserDto::class.java)
    }

    fun findByid(request: ServerRequest): Mono<ServerResponse> {
        val id:UUID = UUID.fromString(request.pathVariable("id"))
        return ServerResponse
            .ok()
            .body(appUserService.findById(id) , AppUserDto::class.java)
    }

    fun addUser(request: ServerRequest): Mono<ServerResponse>{
        val appUserMonoRequest = request.bodyToMono(AppUserReq::class.java)
        val appUserResultMono: Mono<AppUserDto> = appUserMonoRequest.flatMap {
            appUserService.save(it)
        }
        return ServerResponse
            .ok()
            .body(appUserResultMono , AppUserDto::class.java)
    }

}