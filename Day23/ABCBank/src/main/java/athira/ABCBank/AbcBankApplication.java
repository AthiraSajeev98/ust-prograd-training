package athira.ABCBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AbcBankApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(AbcBankApplication.class, args);
        FundTransfer fundTransfer = context.getBean(FundTransfer.class);
        Account account = context.getBean(Account.class);
        Customer customer1 = context.getBean(Customer.class);
        Customer customer2 = context.getBean(Customer.class);

        customer1.setCustomerAccount("Athira Sajeev", "9137290754", "32106753904", 5000);
        customer2.setCustomerAccount("Adhav Arun", "987649723", "42064918964", 1500);


        fundTransfer.transferFund(1000, customer1, customer2);
        System.out.println("***********************Transferring fund form*********************\n");
        account.displayAccountOfCustomer(customer1);
        System.out.println("\n***********************Fund transferred to*********************\n");
        account.displayAccountOfCustomer(customer2);
        System.out.println("\n***********************Transfer completed...***********************");


    }

}
//Create a Spring Boot application for ABC Bank. using this application,
//the customers of the bank should be able to access their account details
//and transfer funds to the other accounts of the same bank.
//This application should consist of the following entities:
//Customer:To store information about the customers of the bank
//Account:To store information about the existing accounts of the bank
//FundTransfer:To store information about the funds that are transferred from one account to the other.
//Create the application and inject dependencies in the entities.

