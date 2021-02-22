package com.dc.transactions.accountTypes

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
class AccountTypes (@Id val accountType: String,
                    val name: String)