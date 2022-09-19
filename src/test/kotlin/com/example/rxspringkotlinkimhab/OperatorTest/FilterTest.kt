package com.example.rxspringkotlinkimhab.OperatorTest

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

class FilterTest {
    @Test
    fun filter(){
        val cities = listOf("Kolkata","Pune","Mumbai")
        val fluxCities = Flux.fromIterable(cities)
        val filterCities = fluxCities.filter{ city->city.length > 6 }

        StepVerifier.create(filterCities)
            .expectNext("Kolkata")
            .verifyComplete()
    }

    @Test
    fun filter2(){
        val cities = listOf("Kolkata","Pune","Mumbai")
        val fluxCities = Flux.fromIterable(cities)
        val filterCities = fluxCities.filter{ city->city.startsWith("K") }

        StepVerifier.create(filterCities)
            .expectNext("Kolkata")
            .verifyComplete()
    }
}