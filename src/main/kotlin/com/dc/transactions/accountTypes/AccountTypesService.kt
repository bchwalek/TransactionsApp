package com.dc.transactions.accountTypes

import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountTypesService(private val accounttypesRepository: AccountTypesRepository) {

    fun findById(id: String): Optional<AccountTypes> {
        return accounttypesRepository.findById(id)
    }

    fun add(accounttypes: AccountTypes) {
        accounttypesRepository.save(accounttypes)
    }

    fun deleteAll() {
        accounttypesRepository.deleteAll()
    }
}