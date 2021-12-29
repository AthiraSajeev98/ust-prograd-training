package athira.ABCBank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Customer {

    String customerName;
    String phoneNumber;
    String accountNumber;
    double accountBalance;

    public void setCustomerAccount(String customerName, String phoneNumber, String accountNumber, double accountBalance) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void displayCustomerAccount(Customer customer) {
        System.out.println("Beneficiary Name : " + this.customerName);
        System.out.println("Beneficiary Phone Number : " + this.phoneNumber);
        System.out.println("Account Number : " + this.accountNumber);
    }


}
//Customer:To store information about the customers of the bank