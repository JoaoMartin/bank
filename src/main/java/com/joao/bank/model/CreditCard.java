package com.joao.bank.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "credit_cards")
public class CreditCard {
	 @Id
	 private String id;
	 private double creditLimit;
	 private double balance;
}
