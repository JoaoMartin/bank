package com.joao.bank.service;

import com.joao.bank.model.AuthorizedSigner;
import com.joao.bank.model.BankAccount;
import com.joao.bank.model.Client;
import com.joao.bank.model.CreditProduct;
import com.joao.bank.model.Titular;

public interface ClientService {
	 Client createClient(Client client);
	 Client getClientById(String id);
	 BankAccount createAccount(BankAccount bankAccount);
	 CreditProduct createCreditProduct(CreditProduct creditProduct);
	 Titular createTitular(Titular titular);
	 AuthorizedSigner createAuthorizedSigner(AuthorizedSigner authorizedSigner);
}
