package athira.sajeev.BookMyMovie.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {
    @Id
    @Column(nullable = false,unique = true)
    private String userName;
    private String password;
    @Column(nullable = false)
    private String name;
    private Integer age;
    private String gender;
    @Column(nullable = false)
    private String emailID;
    private String address;
    @Column(nullable = false)
    private Long phoneNo;
    private Double walletAccountBalance = 500.0;
//
    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Tickets> tickets;

    public Users(){}

    public Users(String userName, String password, String name, Integer age, String gender, String emailID, String address, Long phoneNo) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.emailID = emailID;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Double getWalletAccountBalance() {
        return walletAccountBalance;
    }

    public void setWalletAccountBalance(Double walletAccountBalance) {
        this.walletAccountBalance = walletAccountBalance;
    }

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }


    public void addTickets(Tickets tickets) {
        this.tickets.add(tickets);
    }
}
