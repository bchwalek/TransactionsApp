package com.dc.transactions

import com.dc.transactions.transactions.TransactionsDto
import com.dc.transactions.transactions.TransactionsService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transactions")
public class AppController(private val transactionsService: TransactionsService) {


    @GetMapping
    @ResponseBody
    fun search(@RequestParam(required = false) customerID: List<String>, @RequestParam(required = false) accountType: List<String>): List<TransactionsDto> {

        if ((customerID.isEmpty() || customerID[0].equals("all")) && (accountType.isEmpty() || accountType[0].equals("all"))) {
            return transactionsService.findAllTrans()

        } else if (customerID.isEmpty() || customerID[0].equals("all")) {

            return transactionsService.findByAccount(accountType)

        } else if (accountType.isEmpty() || accountType[0].equals("all")) {

            return transactionsService.findByCustomer(customerID)

        } else {
            return transactionsService.findByAccountAndCustomer(accountType, customerID)
        }

    }
}




