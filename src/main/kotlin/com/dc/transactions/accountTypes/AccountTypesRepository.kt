package com.dc.transactions.accountTypes

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
open interface AccountTypesRepository : MongoRepository<AccountTypes, String> {

    fun findByAccountType(accountType: List<String>): AccountTypes

}