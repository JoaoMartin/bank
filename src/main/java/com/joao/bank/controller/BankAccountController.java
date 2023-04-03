package com.joao.bank.controller;

import java.net.URI;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.bank.model.BankAccount;
import com.joao.bank.service.BankAccountService;
import com.joao.bank.service.ClientService;

@RestController
@RequestMapping("/bank_accounts")
public class BankAccountController {
	
	 @Autowired
	 private BankAccountService bankAccountService;

	 @PostMapping("/{idBankAccount}/deposits")
	 public ResponseEntity<Void> toDeposit(@PathVariable String idBankAccount,@RequestBody Map<String, Object> requestBody) {
		 double numericAmmount = Double.parseDouble(requestBody.get("ammount").toString());
		 bankAccountService.toDeposit(idBankAccount, numericAmmount);
	     return ResponseEntity.noContent().build();
	 }

	 @PostMapping("/{idBankAccount}/withdrawal")
	 public ResponseEntity<Void> withdrawal(@PathVariable String idBankAccount, @RequestBody String ammount) {
		 double numericAmmount = Double.parseDouble(ammount);
		 bankAccountService.withdrawal(idBankAccount, numericAmmount);
	     return ResponseEntity.noContent().build();
	 }

	 @GetMapping("/{idBankAccount}/balance")
	 public ResponseEntity<Double> consultarSaldo(@PathVariable String idBankAccount) {
	     double balance = bankAccountService.consultMoney(idBankAccount);
	     return ResponseEntity.ok(balance);
	 }


}
