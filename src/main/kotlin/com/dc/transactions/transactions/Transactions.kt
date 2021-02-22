package com.dc.transactions.transactions


import org.springframework.data.mongodb.core.mapping.Document


@Document
data class Transactions (val transactionId: String,
                         val transactionAmount: Double,
                         val accountType: String,
                         val customer: String,
                         val transactionDate: String)