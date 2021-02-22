package com.dc.transactions.transactions

import com.dc.transactions.accountTypes.AccountTypesService
import com.dc.transactions.customer.CustomerService
import org.springframework.stereotype.Service


@Service
class TransactionsService(private val transactionsRepository: TransactionsRepository,
                          private val accountTypesService: AccountTypesService,
                          private val customerService: CustomerService) {


    fun add(transactions: Transactions) {
        transactionsRepository.save(transactions)
    }

    fun deleteAll() {
        transactionsRepository.deleteAll()
    }

    fun findAllTrans(): List<TransactionsDto> {
        val listDtoTrans = listTransactionsToDto(transactionsRepository.findAll())
        return listDtoTrans
    }

    fun findByAccount(accountType: List<String>): List<TransactionsDto> {
        val listDtoTrans = listTransactionsToDto(transactionsRepository.findByAccount(accountType))
        return listDtoTrans
    }

    fun findByCustomer(customer: List<String>): List<TransactionsDto> {
        val listDtoTrans = listTransactionsToDto(transactionsRepository.findByCustomer(customer))
        return listDtoTrans
    }

    fun findByAccountAndCustomer(accountType: List<String>, customer: List<String>): List<TransactionsDto> {
        val listDtoTrans = listTransactionsToDto(transactionsRepository.findByAccountAndCustomer(accountType, customer))
        return listDtoTrans
    }

    fun listTransactionsToDto(transList: List<Transactions>): List<TransactionsDto> {
        val listDTOtransactions = mutableListOf<TransactionsDto>()
        transList.forEach { trans -> listDTOtransactions.add(trans.toTransactiosDTO(customerService.findById(trans.customer).get(), accountTypesService.findById(trans.accountType).get())) }
        listDTOtransactions.sortBy { t -> t.transDtoAmount }
        return listDTOtransactions
    }
}