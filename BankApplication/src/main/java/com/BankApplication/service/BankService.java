package com.BankApplication.service;

import com.BankApplication.model.BankModel;

public interface BankService {

	
	public boolean saveUser(BankModel bankmodel);
	public BankModel checkBalance(int accountNumber,String password);
	public boolean deposit(int accountNumber,String password,double amount);
	public BankModel withdraw(int accountNumber, String name, String password, double amount);
	public String transfer(int fromAccount,String password, double amount,int toAccount);

}


