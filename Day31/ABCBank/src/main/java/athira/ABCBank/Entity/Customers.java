package athira.ABCBank.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Entity
public class Customers{
    @Id
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String customerName;

    @Column(unique = true, nullable = false)
    private Long accountNumber;

    @Column(unique = true, nullable = false)
    private Long phoneNumber;

    @Column(nullable = false)
    private String ifscCode;

    private Double balance=1000.00;

    public Customers() {
    }



    public Customers(String username, String password, String customerName, Long accountNumber, Long phoneNumber, String ifscCode) {
        this.username = username;
        this.password = password;
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.phoneNumber = phoneNumber;
        this.ifscCode = ifscCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }





}
