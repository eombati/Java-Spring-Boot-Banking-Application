package com.nyambane.banking_app.dto;

/**
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.http.HttpStatusCode;

//Translator Class - A Data Transfer Object used to pass information between layers
@Data
//@ToString
public class AccountDto {
    private Long id;
    private String accountHolderLastName;
    private String accountHolderFirstName;
    private String phoneNumber;
    private String emailAddress;
    private double balance;

    public AccountDto(Long id, String accountHolderLastName, String accountHolderFirstName, String phoneNumber, String emailAddress, double balance) {
        this.id = id;
        this.accountHolderLastName = accountHolderLastName;
        this.accountHolderFirstName = accountHolderFirstName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.balance = balance;
    }

    public AccountDto() {
    }

    public Long getId() {return id;}
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

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", accountHolderLastName='" + accountHolderLastName + '\'' +
                ", accountHolderFirstName='" + accountHolderFirstName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", balance=" + balance +
                '}';
    }
    **/

//USING RECORD INSTEAD OF DTO
     public record AccountDto(Long id,
                              String accountHolderLastName,
                              String accountHolderFirstName,
                              String phoneNumber,
                              String emailAddress,
                              double balance) {
     }

