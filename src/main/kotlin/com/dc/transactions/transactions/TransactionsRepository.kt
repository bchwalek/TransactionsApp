package com.dc.transactions.transactions

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query


interface TransactionsRepository : MongoRepository<Transactions, String> {

    @Query("{accountType:{\$in:?0}}")
    fun findByAccount(accountType: List<String>): List<Transactions>

    @Query("{customer:{\$in:?0}}")
    fun findByCustomer(customer: List<String>): List<Transactions>

    @Query("{\$and: [{accountType:{\$in:?0}}, {customer:{\$in:?1}}]}")
    fun findByAccountAndCustomer(accountType: List<String>, customer: List<String>): List<Transactions>
}