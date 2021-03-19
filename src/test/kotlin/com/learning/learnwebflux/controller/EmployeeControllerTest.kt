package com.learning.learnwebflux.controller

import com.learning.learnwebflux.repository.EmployeeRepository
import net.minidev.json.JSONObject
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest(EmployeeController::class,EmployeeRepository::class)
class EmployeeControllerTest  {

    @Autowired
    lateinit var client: WebTestClient

    @Test
    fun `should return all employees`() {
        client
                .get()
                .uri("/v1/employees")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().is2xxSuccessful
    }
}