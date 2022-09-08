package com.example.rxspringkotlinkimhab

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux
import java.time.Duration

//@Suppress("DEPRECATION")
@SpringBootTest
class RxSpringKotlinKimhabApplicationTests {

    @Test
    fun fluxTest() {
        Flux.just(1, 2, 3, 4)
            .log()
            .subscribe { data -> println(data) }

//		val flux = Flux.just(1,2,3,4)
//		flux.subscribe { data -> println(data) }
    }

    @Test
    fun fluxWithError() {
        Flux.just(14, 23, 43, 44)
//            .concatWith(Flux.error(RuntimeException("have some exception")))
            .log()
            .subscribe(
                { data -> println(data) },
                { error -> println("Error is $error") },
                { println("Completed") })
    }

    @Test
    fun fluxTestWithIterable() {
        Flux.fromIterable(listOf(33, 22, 234))
            .log()
            .subscribe { data -> println(data) }
    }

    @Test
    fun fluxTestWithRange() {
        Flux.range(5,6)
//            .log()
            .subscribe { data -> println(data) }
    }
    @Test
    fun fluxTestWithInterval() {
        Flux.interval(Duration.ofSeconds(2))
            .subscribe { data -> println(data) }
        Thread.sleep(5000)
    }
    @Test
    fun fluxTestWithTakeOperator() {
        Flux.interval(Duration.ofSeconds(1))
            .take(3)
            .subscribe { data -> println(data) }
        Thread.sleep(10000)
    }

    @Test
    fun fluxTestWithRequest() {
        Flux.range(1,9)
            .log()
            .subscribe ({ data -> println(data)},{},{},{sub -> sub.request(5)})
        Thread.sleep(10000)
    }
    @Test
    fun fluxTestWithErrorHandling() {
        Flux.just("A","AC","X")
            .concatWith(Flux.error(RuntimeException("Some error here ")))
            .onErrorReturn("Some item on exception")
            .log()
            .subscribe { data -> println(data) }
        Thread.sleep(5000)
    }
}
