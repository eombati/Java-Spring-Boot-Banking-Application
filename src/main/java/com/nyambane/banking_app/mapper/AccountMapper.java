package com.nyambane.banking_app.mapper;

import com.nyambane.banking_app.dto.AccountDto;
import com.nyambane.banking_app.entity.Account;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor

//mapToAccount - Converts a DTO to an entity object. If the input is null, returns null.
public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        if (accountDto == null) {
            return null;
        }
        return new Account(
                accountDto.id(),
                accountDto.accountHolderLastName(),
                accountDto.accountHolderFirstName(),
                accountDto.phoneNumber(),
                accountDto.emailAddress(),
                accountDto.balance()
        );
    }

//mapToAccountDto - Converts an entity object back into a DTO. Also returns null if the input is null.
    public static AccountDto mapToAccountDto(Account account){
        if(account == null){
            return null;
        }

        return new AccountDto(
                account.getId(),
                account.getAccountHolderLastName(),
                account.getAccountHolderFirstName(),
                account.getPhoneNumber(),
                account.getEmailAddress(),
                account.getBalance()
        );
    }
}
