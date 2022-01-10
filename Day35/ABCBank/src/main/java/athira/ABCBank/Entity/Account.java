package athira.ABCBank.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {

    @Column(unique = true, nullable = false)
    private String username;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String ifscCode;

    @Column(nullable = false)
    private String branch;

    private Double balance=1000.00;

    @OneToOne(mappedBy = "account")
    private Customers customers;

    public Account(){}

    public Account(String username, String accountNumber, String ifscCode, String branch) {
        this.username = username;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.branch = branch;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Customers getCustomers() {
        return customers;
    }
}
