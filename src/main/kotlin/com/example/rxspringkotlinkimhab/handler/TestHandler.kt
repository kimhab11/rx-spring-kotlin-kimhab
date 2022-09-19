package com.example.rxspringkotlinkimhab.handler

import com.example.rxspringkotlinkimhab.model.Students
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class TestHandler() {
    fun sayHello(serverRequest: ServerRequest): Mono<ServerResponse> =
        ServerResponse
            .badRequest()
            .body(Mono.just(777), Int::class.java)

    fun getStudentName(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse
            .ok()
            .body(
                Flux.just(Students("A"), Students("B")), Students::class.java
            )
    }

    fun findStuByID(serverRequest: ServerRequest): Mono<ServerResponse> {
        val name = serverRequest.pathVariable("name")
        val id = serverRequest.pathVariable("id")
        return ServerResponse
            .ok()
            .body(Mono.just("$name + $id"), String::class.java)
    }

    fun search(serverRequest: ServerRequest): Mono<ServerResponse> {
        val key = serverRequest.queryParam("name")
        return ServerResponse
            .ok()
            .body(Mono.just(key.get()), String::class.java)
    }

    fun addStudent(serverRequest: ServerRequest): Mono<ServerResponse> {
        val studentRequestMono = serverRequest.bodyToMono(Students::class.java)
        return ServerResponse
            .ok()
            .body(studentRequestMono, Students::class.java)
    }
}