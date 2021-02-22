package com.dc.transactions.transactions

import com.fasterxml.jackson.annotation.JsonProperty

data class TransactionsDto(@JsonProperty("Data transakcji:") var transDtoDate: String,
                           @JsonProperty("Identyfikator transakcji:") var transDtoId: String,
                           @JsonProperty("Kwota transakcji:") var transDtoAmount: Double,
                           @JsonProperty("Rodzaj rachunku:") var tranDtoAccountType: String,
                           @JsonProperty("Imię zlecającego:")  var transDtoFirstName:String,
                           @JsonProperty("Nazwisko zlecającego:") var transDtoLastName: String)

