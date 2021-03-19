package com.learning.learnwebflux

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers.parallel
import reactor.kotlin.core.publisher.toMono
import reactor.test.StepVerifier

class FlatMapTest
{

    @Test
    fun flatMapTest() {
        val emplIds = listOf("1","2","3","4","5","6","7")

        val empName = Flux.fromIterable(emplIds)
                .flatMap { id -> getEmpDetails(id) }
                .log()

        StepVerifier.create(empName)
                .expectNextCount(8)
                .verifyComplete()

    }


    @Test
    fun flatMapTestUsingParallelScheduler() {
        val emplIds = listOf("1","2","3","4","5","6","7")

        val empName = Flux.fromIterable(emplIds)
                .window(2)//returns Flux<Flux<String>>
                .flatMapSequential {
                    identifiers -> identifiers.flatMap {
                    id -> getEmpDetails(id)
                    }.subscribeOn(parallel()) }
                .log()

        StepVerifier.create(empName)
                .expectNextCount(7)
                .verifyComplete()

    }


    private fun getEmpDetails(id:String?): Mono<String> {
        val employees = mapOf(
                "1" to "Sam",
                "2" to "Sam",
                "3" to "Sam",
                "4" to "Sam",
                "5" to "Sam",
                "6" to "Sam",
                "7" to "Sam",
                "8" to "Sam"
        )
        Thread.sleep(1000)
        return employees.getOrDefault(id,"Not found").toMono()
    }
}