package com.learning.learnwebflux

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux

class MapTest {

    @Test
    fun mapTest() {
        Flux.range(1,5)
                .map { data -> data*data }
                .subscribe( {data -> println(data)})
    }

    @Test
    fun mapTest2() {
        Flux.range(1,5)
                .map { it*it }
                .subscribe( {println(it)})
    }

    @Test
    fun mapTest3() {
        Flux.range(1,10)
                .map { it*it }
                .filter({it%2 == 0})
                .subscribe( {println(it)})
    }
}