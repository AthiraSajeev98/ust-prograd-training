package athira.ABCBank.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
public class Customers{
    @Id
    @Column(unique = true, nullable = false,updatable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String address;

    @Column(unique = true, nullable = false)
    private Long phoneNumber;

    @Column(unique = true, nullable = false)
    private String emailId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="accountNumber")
    private Account account;

    public Customers() {}

    public Customers(String username, String password, String customerName, String address, Long phoneNumber, String emailId) {
        this.username = username;
        this.password = password;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
