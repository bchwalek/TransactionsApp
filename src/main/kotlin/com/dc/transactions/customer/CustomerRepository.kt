package com.dc.transactions.customer

import org.springframework.data.mongodb.repository.MongoRepository


interface CustomerRepository : MongoRepository<Customer, String>