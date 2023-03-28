package com.joao.bank.service.impl;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.bank.enums.ClientType;
import com.joao.bank.enums.TypeBankAccount;
import com.joao.bank.model.AuthorizedSigner;
import com.joao.bank.model.BankAccount;
import com.joao.bank.model.Client;
import com.joao.bank.model.CreditProduct;
import com.joao.bank.model.Titular;
import com.joao.bank.repository.AuthorizedSignerRepository;
import com.joao.bank.repository.BankAccountRepository;
import com.joao.bank.repository.ClientRepository;
import com.joao.bank.repository.CreditProductRepository;
import com.joao.bank.repository.TitularRepository;
import com.joao.bank.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	 @Autowired
	 private ClientRepository clientRepository;
	 @Autowired
	 private BankAccountRepository bankAccountRepository;
	 @Autowired
	 private CreditProductRepository creditProductRepository;
	 @Autowired
	 private TitularRepository titularRepository;
	 @Autowired
	 private AuthorizedSignerRepository authorizedSignerRepository;
	  


	    
	  @Override
	    public Client createClient(Client client) {
		  validateClient(client);
	      return clientRepository.save(client);
	    }
	  
	  @Override
	  public BankAccount createAccount(BankAccount bankAccount) {
	     validateBankAccount(bankAccount);
	     return bankAccountRepository.save(bankAccount);
	  }
	  
	  @Override
	  public Client getClientById(String id) {
	      Optional<Client> clientOptional = clientRepository.findById(id);
	      return clientOptional.orElse(null);
	  }

	    @Override
	    public CreditProduct createCreditProduct(CreditProduct creditProduct) {
	        return creditProductRepository.save(creditProduct);
	    }

	    @Override
	    public Titular createTitular(Titular titular) {
	        return titularRepository.save(titular);
	    }

	    @Override
	    public AuthorizedSigner createAuthorizedSigner(AuthorizedSigner authorizedSigner) {
	        return authorizedSignerRepository.save(authorizedSigner);
	    }
	    
	    private void validateClient(Client client) {
	        if (client.getClientType().equals(ClientType.PERSONAL)) {
	            // un cliente personal solo puede tener un máximo de una cuenta de ahorro, una cuenta corriente o cuentas a plazo fijo
	            List<BankAccount> accounts = bankAccountRepository.findByIdClient(client.getId());
	            long cuentaAhorro = accounts.stream().filter(c -> c.getTypeAccount().equals(TypeBankAccount.AHORRO)).count();
	            long cuentaCorriente = accounts.stream().filter(c -> c.getTypeAccount().equals(TypeBankAccount.CORRIENTE)).count();
	            long cuentaPlazoFijo = accounts.stream().filter(c -> c.getTypeAccount().equals(TypeBankAccount.PLAZO_FIJO)).count();
	            if (cuentaAhorro + cuentaCorriente + cuentaPlazoFijo > 1) {
	                throw new IllegalArgumentException("Un cliente personal solo puede tener un máximo de una cuenta de ahorro, una cuenta corriente o cuentas a plazo fijo");
	            }
	        } else if (client.getClientType().equals(ClientType.EMPRESARIAL)) {
	            // un cliente empresarial no puede tener una cuenta de ahorro o de plazo fijo, pero sí múltiples cuentas corrientes
	            List<BankAccount> accounts = bankAccountRepository.findByIdClient(client.getId());
	            boolean tieneCuentaAhorro = accounts.stream().anyMatch(c -> c.getTypeAccount().equals(TypeBankAccount.AHORRO));
	            boolean tieneCuentaPlazoFijo = accounts.stream().anyMatch(c -> c.getTypeAccount().equals(TypeBankAccount.PLAZO_FIJO));
	            if (tieneCuentaAhorro || tieneCuentaPlazoFijo) {
	            	 throw new IllegalArgumentException("Un cliente empresarial no puede tener una cuenta de ahorro o de plazo fijo");
	            }
	        }
	    }
	    
	    private void validateBankAccount(BankAccount bankAccount) {
	        Client client = clientRepository.findById(bankAccount.getIdClient())
	                .orElseThrow(() -> new RuntimeException("El cliente no existe"));

	        // Validar que el cliente no tenga una cuenta de ahorro o plazo fijo si es empresarial
	        if (client.getClientType().equals(ClientType.EMPRESARIAL) && (bankAccount.getTypeAccount().equals(TypeBankAccount.AHORRO) 
	        		|| bankAccount.getTypeAccount().equals(TypeBankAccount.PLAZO_FIJO))) {
	            throw new RuntimeException("Los clientes empresariales no pueden tener cuentas de ahorro o plazo fijo");
	        }

	        // Validar que el cliente personal no tenga más de una cuenta de ahorro, cuenta corriente o plazo fijo
	        if (client.getClientType().equals(ClientType.PERSONAL)) {
	            List<BankAccount> accounts = bankAccountRepository.findByIdClient(client.getId());
	            long cuentasSimilares = accounts.stream().filter(c -> c.getTypeAccount().equals(bankAccount.getTypeAccount())).count();

	            if (cuentasSimilares >= 1) {
	                throw new RuntimeException("Los clientes personales solo pueden tener un máximo de una cuenta de ahorro, cuenta corriente o plazo fijo");
	            }
	        }
	    }
	
	 
}
