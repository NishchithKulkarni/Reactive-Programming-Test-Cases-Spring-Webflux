package com.learning.learnwebflux

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

class FilterTest {

    @Test
    fun filterTest() {
        val cities = listOf("Kolkata","Pune","Mumbai","Jaipur","Delhi")

        val fluxCities = Flux.fromIterable(cities)

        val filteredCities = fluxCities.filter{ city -> city.length > 6}

        StepVerifier.create(filteredCities)
                .expectNext("Kolkata")
                .verifyComplete()
    }
    @Test
    fun filterTest2() {
        val cities = listOf("Kolkata","Pune","Mumbai","Jaipur","Delhi")

        val fluxCities = Flux.fromIterable(cities)

        val filteredCities = fluxCities.filter{ city -> city.startsWith("P")}

        StepVerifier.create(filteredCities)
                .expectNext("Pune")
                .verifyComplete()
    }
}