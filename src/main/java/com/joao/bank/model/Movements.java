package com.joao.bank.model;

import java.time.LocalDateTime;

import com.joao.bank.enums.MovementType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Movements {
	
    private MovementType tipoMovimiento;
    private double ammount;
    private LocalDateTime dateMove;
}
