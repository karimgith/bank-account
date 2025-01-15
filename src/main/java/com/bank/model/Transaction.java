package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Transaction {

    private double amount;
    private String type;
    private LocalDateTime date;
}
