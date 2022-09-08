package com.example.rxspringkotlinkimhab

import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono
import reactor.test.StepVerifier


// Mono can have only 1 or 0 data
class MonoTest {
    @Test
    fun mono1(){
        Mono.just("AA")
            .log()
            .subscribe({data -> println("My data is $data") })
    }
    @Test
    fun mono2(){
        Mono.error<Exception>(Exception("Have exception"))
            .log()
            .doOnError { error -> println("error merge  ${error.message}") }
            .subscribe({},{error -> println("error merge  ${error.message}") })
    }

    @Test
    fun junitTest1(){
        val a = Mono.just("A")
            .log()
        StepVerifier.create(a)
            .expectNext("A")
            .verifyComplete()
    }
    @Test
    fun junitTest2(){
        val a = Mono.error<Exception>(Exception("Some exception"))
            .log()
        StepVerifier.create(a)
            .expectError(Exception::class.java)
            .verify()
    }
}