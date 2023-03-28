package com.joao.bank.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.joao.bank.enums.TypeBankAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bank_account")
public class BankAccount {
    @Id
    private String id;
    private TypeBankAccount typeAccount;
    private String idClient;
    private Double balance;
    private BigDecimal interestRate;
    private Integer dayTerm;
}