package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class BankAccountService {

    @Autowired
    private Account account;

    public boolean deposit(double amount) {
        log.info("Deposit : {}", amount);
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            account.getTransactions().add(new Transaction(amount, "Deposit", LocalDateTime.now()));
            return true;
        }
        log.warn("Invalid deposit : {}", amount);
        return false;
    }

    public boolean withdraw(double amount) {
        log.info("Withdraw : {}", amount);
        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            account.getTransactions().add(new Transaction(amount, "Withdrawal", LocalDateTime.now()));
            return true;
        }
        log.warn("Invalid withdrawal : {}", amount);
        return false;
    }

    public Account getAccountDetails() {
        return account;
    }

}
