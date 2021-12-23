package athira.ABCBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FundTransfer {
    ArrayList<String> accountNumberList = new ArrayList<String>(List.of("32106753904", "42064918964"));

    public void transferFund(double amount, Customer customer1, Customer customer2) {
        if (accountNumberList.contains(customer1.accountNumber) && accountNumberList.contains(customer2.accountNumber)) {
            customer1.setAccountBalance(customer1.accountBalance - amount);
            customer2.setAccountBalance(customer2.accountBalance + amount);
        }
    }
}

//FundTransfer:To store information about the funds that are transferred from one account to the other.
