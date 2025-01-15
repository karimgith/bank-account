package com.bank.controller;

import com.bank.model.Account;
import com.bank.service.BankAccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @Operation(summary = "Money deposit")
    @PostMapping("/deposit")
    public String deposit(@RequestParam double amount) {
        if (bankAccountService.deposit(amount)) {
            return "Successful deposit";
        }
        return "Failed deposit";
    }

    @Operation(summary = "Money withdrawal")
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam double amount) {
        if (bankAccountService.withdraw(amount)) {
            return "Successful withdrawal";
        }
        return "Failed withdrawal";
    }

    @Operation(summary = "Account details / transaction(s)")
    @GetMapping("/transaction")
    public Account getAccountDetails() {
        return bankAccountService.getAccountDetails();
    }
}
