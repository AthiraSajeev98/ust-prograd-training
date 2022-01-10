package athira.ABCBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AbcBankApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(AbcBankApplication.class, args);

        System.out.println("Application Running...!");
    }

}
//Requirement-1
//Create a Spring Boot application for ABC Bank. using this application,
//the customers of the bank should be able to access their account details
//and transfer funds to the other accounts of the same bank.
//This application should consist of the following entities:
//Customer:To store information about the customers of the bank
//Account:To store information about the existing accounts of the bank
//FundTransfer:To store information about the funds that are transferred from one account to the other.
//Create the application and inject dependencies in the entities.

//Requirement-2
//To avail online services of the bank, the customers have to log in to the website by using their username and password.
//After the customers successfully log into the website, they can view their account details on the user account page

//Requirement-3
// Implement AOP for simple logging use cases
//Implement AOP for the following:
//The Transaction Password is validated to authenticate the user
//The application ensures that the amount to be transferred does not exceed the available account balance
//The users' account balance is updated
