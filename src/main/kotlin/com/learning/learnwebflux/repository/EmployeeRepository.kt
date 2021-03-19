package com.learning.learnwebflux.repository

import com.learning.learnwebflux.model.Employee
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface EmployeeRepository:ReactiveMongoRepository<Employee,String> {
}