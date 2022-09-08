package com.example.rxspringkotlinkimhab

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

class FluxTest {
    @Test
    fun flux1(){
        val  flux = Flux.just("A","B","V").log()

        StepVerifier.create(flux)
            .expectNext("A") //.expectNext("A","B","V")
            .expectNext("B")
            .expectNext("V")
            .verifyComplete()
    }
    @Test
    fun flux2(){
        val  flux = Flux.just("A","B","C")
            .concatWith(Flux.error(RuntimeException("Error have same @")))
            .log()

        StepVerifier.create(flux)
            .expectNext("A") //.expectNext("A","B","V")
            .expectNext("B")
            .expectNext("C")
            .expectErrorMessage("Error have same @")
            // .expectError(RuntimeException::class.java)
            .verify()
    }
}