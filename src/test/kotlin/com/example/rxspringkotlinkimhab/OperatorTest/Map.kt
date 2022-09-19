package com.example.rxspringkotlinkimhab.OperatorTest

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux

class Map {
    @Test
    fun map1(){
        Flux.range(7,5)
            .map { it.toString() + " String form" }
            .subscribe({ println(it) })
    }
    @Test
    fun map2(){
        Flux.range(1,6)
            .map {it * it}
            .filter({it % 2 == 0})
            .subscribe({ println(it) })
    }

}