package com.joao.bank.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.joao.bank.enums.TypeCreditProduct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "credit_product")
public class CreditProduct {
    @Id
    private String id;
    private TypeCreditProduct typeCreditProduct;
    private String idClient;
    private double ammount;
    private int monthTerm;
    private double interestRate;
}
