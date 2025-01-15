package com.bank.service;

import com.bank.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankAccountServiceTest {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private Account account;

    @BeforeEach
    void init() {
        account.setBalance(0);
    }

    @Test
    void testDeposit() {
        boolean result = bankAccountService.deposit(10);
        assertTrue(result);
        assertEquals(10, account.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccountService.deposit(20);
        boolean result = bankAccountService.withdraw(10);
        assertTrue(result);
        assertEquals(10, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientBalance() {
        bankAccountService.deposit(15);
        boolean result = bankAccountService.withdraw(20);
        assertFalse(result);
    }
}
