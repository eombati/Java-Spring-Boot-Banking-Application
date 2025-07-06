package com.nyambane.banking_app.entity;

import jakarta.persistence.*;
import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Table(name = "accounts")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountHolderLastName")
    private String accountHolderLastName;
    @Column(name = "accountHolderFirstName")
    private String accountHolderFirstName;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "emailAddress")
    private String emailAddress;
    @Column(name = "balance")
    private double balance;


    public Account(Long id, String accountHolderLastName, String accountHolderFirstName, String phoneNumber, String emailAddress, double balance) {
        this.id = id;
        this.accountHolderLastName = accountHolderLastName;
        this.accountHolderFirstName = accountHolderFirstName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.balance = balance;
    }

    public Account(){

    }



    public Long getId() {
        return id;
    }

    public String getAccountHolderLastName() {
        return accountHolderLastName;
    }

    public String getAccountHolderFirstName() {
        return accountHolderFirstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountHolderLastName(String accountHolderLastName) {
        this.accountHolderLastName = accountHolderLastName;
    }

    public void setAccountHolderFirstName(String accountHolderFirstName) {
        this.accountHolderFirstName = accountHolderFirstName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
