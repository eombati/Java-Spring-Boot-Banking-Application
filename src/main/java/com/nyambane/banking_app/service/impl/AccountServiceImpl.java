package com.nyambane.banking_app.service.impl;

import com.nyambane.banking_app.dto.AccountDto;
import com.nyambane.banking_app.entity.Account;
import com.nyambane.banking_app.exception.AccountException;
import com.nyambane.banking_app.mapper.AccountMapper;
import com.nyambane.banking_app.repository.AccountRepository;
import com.nyambane.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Worker Bee - handles the business logic related to accounts.
//uses the AccountRepository to persist or retrieve data, and the AccountMapper to convert data as needed.

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        System.out.println("Incoming DTO: " + accountDto );

        Account account = AccountMapper.mapToAccount(accountDto);
        System.out.println("Mapped Account Entity: " + account );

        Account savedAccount = accountRepository.save(account);
        System.out.println("Saved Account Entity: " + savedAccount);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountByID(Long id) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account with ID " + id + " does not exist"));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account with ID " + id + " does not exist"));

        double totalAmount = account.getBalance() + amount;
        account.setBalance(totalAmount);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account with ID " + id + " does not exist"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient amount");
        }

        double totalAmount = account.getBalance() - amount;
        account.setBalance(totalAmount);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
      List<Account> accounts =  accountRepository.findAll();
      return accounts.stream().map(account -> AccountMapper.mapToAccountDto(account))
              .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new AccountException("Account with ID " + id + " does not exist"));

        accountRepository.deleteById(id);

    }
}
