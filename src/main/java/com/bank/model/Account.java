package com.bank.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Account {
    private double balance = 0;
    private List<Transaction> transactions = new ArrayList<>();

}
