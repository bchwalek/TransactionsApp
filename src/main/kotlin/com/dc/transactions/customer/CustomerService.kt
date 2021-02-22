package com.dc.transactions.customer

import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    fun findById(id: String): Optional<Customer> {
        return customerRepository.findById(id)
    }

    fun add(customer: Customer) {
        customerRepository.save(customer)
    }

    fun deleteAll() {
        customerRepository.deleteAll()
    }
}