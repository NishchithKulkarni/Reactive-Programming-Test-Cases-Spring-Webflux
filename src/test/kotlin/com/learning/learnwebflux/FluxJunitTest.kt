package com.learning.Learn.Spring.Webflux.junittest

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier


class FluxJunitTest {

    @Test
    fun fluxJunit() {
        val flux = Flux.just("A","B","C")
                .log()

        StepVerifier.create(flux)
                .expectNext("A","B","C")
                .verifyComplete()
    }
/*
    @Test
    fun fluxJunitError() {
        val flux = Flux.just("A","B","C")
                .concatWith(Flux.error(RuntimeException("Error occured")))
                .log()

        StepVerifier.create(flux)
                .expectNext("A")
                .expectNext("B")
                .expectNext("C")
                .expectErrorMessage("Error occured")
                .expectError(RuntimeException::class.java)
                .verify()
    }*/
}