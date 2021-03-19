package com.learning.learnwebflux

import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

class MonoTest {

    @Test
    fun mono1()
    {
      Mono.just("A")
               .log()
               .subscribe( { data -> println(data)})
    }

    @Test
    fun mono2()
    {
        Mono.error<Exception>(Exception("Some Exception"))
                .log()
                .doOnError{ error -> println("Error occured with $(error.message)")}
                .subscribe()
    }

    @Test
    fun monoJunit()
    {
        val mono = Mono.just("A")
                .log()

        StepVerifier.create(mono)
                .expectNext("A")
                .verifyComplete()
    }

    @Test
    fun monoJunit2()
    {
       val mono = Mono.error<Exception>(Exception("Some exception"))
               .log()

        StepVerifier.create(mono)
                .expectError(Exception::class.java)
                .verify()
    }


}