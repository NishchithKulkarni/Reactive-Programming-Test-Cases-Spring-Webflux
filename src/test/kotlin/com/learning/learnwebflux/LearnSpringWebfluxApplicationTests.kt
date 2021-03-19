package com.learning.learnwebflux

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux

@SpringBootTest
class LearnSpringWebfluxApplicationTests {


	@Test
	fun fluxTest() {
		Flux.just("A", "B", "C")
				.subscribe { data -> println(data) }
	}

	@Test
	fun fluxWithError() {
		Flux.just("A", "B","C")
				.concatWith(Flux.error(RuntimeException("Some exception occured")))
				.log()
				.subscribe({ data -> println(data)},
						{ error -> println("Error is $error") },
						{ println("Completed")}
						)
	}

	@Test
	fun fluxWithIterable() {
		Flux.fromIterable(listOf("A","B","C"))
				.log()
				.subscribe({ data -> println(data)})
	}

	@Test
	fun fluxWithRange() {
		Flux.range(5,6)
			.log()
				.subscribe{ data -> println(data)}
	}

}