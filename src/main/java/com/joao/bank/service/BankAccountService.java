package com.joao.bank.service;

import com.joao.bank.model.BankAccount;

public interface BankAccountService {

	void toDeposit(String idBankAccount, double ammount);

    void withdrawal(String idBankAccount, double ammount);

    double consultMoney(String idBankAccount);

}
