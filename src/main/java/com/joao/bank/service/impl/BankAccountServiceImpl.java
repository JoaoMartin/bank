package com.joao.bank.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.bank.enums.ClientType;
import com.joao.bank.enums.TypeBankAccount;
import com.joao.bank.model.BankAccount;
import com.joao.bank.model.Client;
import com.joao.bank.repository.BankAccountRepository;
import com.joao.bank.repository.ClientRepository;
import com.joao.bank.repository.CreditCardRepository;
import com.joao.bank.repository.CreditProductRepository;
import com.joao.bank.repository.MovementsRepository;
import com.joao.bank.service.BankAccountService;
import com.joao.bank.service.Exception.InvalidRequestException;
import com.joao.bank.service.Exception.ResourceNotFoundException;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	 @Autowired
	 private BankAccountRepository bankAccountRepository;

	    @Override
	    public void toDeposit(String idBankAccount, double ammount) {
	        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findById(idBankAccount);
	        if (bankAccountOptional.isPresent()) {
	        	BankAccount bankAccount = bankAccountOptional.get();
	            double newBalance = bankAccount.getBalance() + ammount;
	            bankAccount.setBalance(newBalance);
	            bankAccountRepository.save(bankAccount);
	        } else {
	            throw new ResourceNotFoundException("No se encontró la cuenta con ID " + idBankAccount);
	        }
	       
	    }

	    @Override
	    public void withdrawal(String idBankAccount, double ammount) {
	        Optional<BankAccount> bankAccountOptional = bankAccountRepository.findById(idBankAccount);
	        if (bankAccountOptional.isPresent()) {
	        	BankAccount bankAccount = bankAccountOptional.get();
	            double newBalance = bankAccount.getBalance() - ammount;
	            bankAccount.setBalance(newBalance);
	            bankAccountRepository.save(bankAccount);
	        } else {
	            throw new ResourceNotFoundException("No se encontró la cuenta con ID " + idBankAccount);
	        }
	    }

	    @Override
	    public double consultMoney(String idBankAccount) {
	    	 BankAccount bankAccount = bankAccountRepository.findById(idBankAccount)
	                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la cuenta con el ID: " + idBankAccount));
	        return bankAccount.getBalance();
	    }

	 
}
