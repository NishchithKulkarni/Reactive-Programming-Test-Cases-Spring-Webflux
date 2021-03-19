package com.learning.learnwebflux.controller

import com.learning.learnwebflux.model.Employee
import com.learning.learnwebflux.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("v1/employees")
class EmployeeController (
    @Autowired
    val employeeRepository: EmployeeRepository
){

    @GetMapping()
    fun getAllEmployees(): Flux<Employee> {
        return employeeRepository.findAll()
    }
}