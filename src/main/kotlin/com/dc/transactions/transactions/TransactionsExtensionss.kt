package com.dc.transactions.transactions

import com.dc.transactions.accountTypes.AccountTypes
import com.dc.transactions.customer.Customer


fun Transactions.toTransactiosDTO(customer: Customer, accountTypes: AccountTypes) = TransactionsDto(
        transDtoDate = transactionDate,
        transDtoId = transactionId,
        transDtoFirstName = customer.firstName.replace(",","."),
        transDtoLastName = customer.lastName,
        transDtoAmount = transactionAmount,
        tranDtoAccountType = accountTypes.name
)