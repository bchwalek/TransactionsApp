package com.dc.transactions

import com.dc.transactions.accountTypes.AccountTypes
import com.dc.transactions.accountTypes.AccountTypesService
import com.dc.transactions.customer.Customer
import com.dc.transactions.customer.CustomerService
import com.dc.transactions.transactions.Transactions
import com.dc.transactions.transactions.TransactionsService
import com.opencsv.CSVReaderHeaderAware
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import java.io.FileReader

@SpringBootApplication
class TransactionsApplication

fun main(args: Array<String>) {
    runApplication<TransactionsApplication>(*args)
}

@Configuration
class Instantiation(private val accountTypesService: AccountTypesService,
                    private val transactionsService: TransactionsService,
                    private val customerService: CustomerService) : CommandLineRunner {



    override fun run(vararg args: String?) {

        accountTypesService.deleteAll()
        transactionsService.deleteAll()
        customerService.deleteAll()


        fun reader(fileName:String) :  List<Map<String, String>> {
            val reader = CSVReaderHeaderAware(FileReader(fileName))
            val resultList = mutableListOf<Map<String, String>>()
            var line = reader.readMap()
            while (line != null) {
                resultList.add(line)
                line = reader.readMap()
            }
            return resultList;
        }


        val listAccount = reader("src/main/resources/accountypes.csv")
        listAccount.forEach{a-> accountTypesService.add(AccountTypes(a.getValue("account_type"), a.getValue("name")))}

        val listTransactions = reader("src/main/resources/transactions.csv")
        listTransactions.forEach{t -> transactionsService.add(Transactions(
                t.getValue("transaction_id"), (t.getValue("transaction_amount").replace(",",".")).toDouble(),
                t.getValue("account_type"), t.getValue("customer_id"), t.getValue("transaction_date"))) }

        val listCustomers = reader("src/main/resources/customers.csv")
        listCustomers.forEach{c-> customerService.add(Customer(c.getValue("id"), c.getValue("first_name"),
                c.getValue("last_name"), c.getValue("last_login_balance")))}
    }

}
