package com.dc.transactions.customer

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Customer(@Id val id: String,
               val firstName: String,
               val lastName: String,
               val lastLoginBalance: String)