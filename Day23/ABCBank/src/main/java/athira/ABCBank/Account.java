package athira.ABCBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Account {

    ArrayList<String> accountNameList = new ArrayList<String>(List.of("Athira Sajeev", "Adhav Arun"));
    ArrayList<String> accountNumberList = new ArrayList<String>(List.of("32106753904", "42064918964"));
    @Autowired
    public Customer customerAccount;

    public void displayAccountOfCustomer(Customer customer) {
        customerAccount = customer;
        if (accountNumberList.contains(customerAccount.accountNumber) && accountNameList.contains(customerAccount.customerName)) {
            customerAccount.displayCustomerAccount(customerAccount);
            System.out.println("Account Balance : " + customerAccount.getAccountBalance());
        }

    }

}
//Account:To store information about the existing accounts of the bank
