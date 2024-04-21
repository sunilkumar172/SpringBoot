package com.BankApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankApplication.Repository.BankRepo;
import com.BankApplication.model.BankModel;

import jakarta.transaction.Transactional;

@Service
public class BankServiceImp implements BankService {

	@Autowired
	private BankRepo bankRepo;
	
	
	@Override
	public boolean saveUser(BankModel bankModel) {
	    try {
	        bankRepo.save(bankModel);
	        return true; // Save successful
	    } catch (Exception e) {
	        // Log the exception or handle it as needed
	        return false; // Save failed
	    }
	}


	@Override
	@Transactional
	public BankModel checkBalance(int accountNumber, String password) {
	    // Retrieve the bank object by account number
	    BankModel bank = bankRepo.findByAccountNumber(accountNumber);

	    // Check if the bank object is not null and the password matches
	    if (bank != null && bank.getPassword().equals(password)) {
	        // Return the bank object if the account is valid
	        return bank;
	    } else {
	        // Return null to indicate an invalid account
	        return null;
	    }
	}


	@Override
    @Transactional
    public boolean deposit(int accountNumber, String password, double amount) {
        // Retrieve the bank object by account number
        BankModel bankModel = bankRepo.findByAccountNumber(accountNumber);

        // Check if the bank object is not null and the password matches
        if (bankModel != null && bankModel.getPassword().equals(password)) {
            // Perform the deposit
            bankModel.setAmount(bankModel.getAmount() + amount);
           bankRepo.save(bankModel);
            return true; // Deposit successful
        } else {
            return false; // Invalid account or password
        }
    }

	 @Override
	    @Transactional
	    public BankModel withdraw(int accountNumber, String name, String password, double amount) {
	        // Retrieve the bank object by account number
	        BankModel bankModel = bankRepo.findByAccountNumber(accountNumber);

	        if (bankModel != null && bankModel.getName().equals(name) && bankModel.getPassword().equals(password)) {
	            // Check if the withdrawal amount is less than the current balance
	            if (bankModel.getAmount() >= amount) {
	                // Perform the withdrawal
	                bankModel.setAmount(bankModel.getAmount() - amount);
	                bankRepo.save(bankModel);

	                // Return the updated Bank object
	                return bankModel;
	            } else {
	                // Insufficient balance, return null or handle it as needed
	                return null;
	            }
	        } else {
	            // Invalid account, name, or password, return null or handle it as needed
	            return null;
	        }
	    }

	 @Override
	 @Transactional
	 public String transfer(int fromAccount, String password, double amount, int toAccount) {
	     // Retrieve the bank objects for fromAccount and toAccount
	     BankModel fromBank = bankRepo.findByAccountNumber(fromAccount);
	     BankModel toBank = bankRepo.findByAccountNumber(toAccount);

	     if (fromBank != null && toBank != null && fromBank.getPassword().equals(password)) {
	         // Check if the transfer amount is valid (non-negative)
	         if (amount <= 0) {
	             return "InvalidTransferAmount";
	         } else if (fromBank.getAmount() >= amount) {
	             // Perform the transfer
	             fromBank.setAmount(fromBank.getAmount() - amount);
	             toBank.setAmount(toBank.getAmount() + amount);

	             // Save the updated Bank objects
	             bankRepo.save(fromBank);
	             bankRepo.save(toBank);

	             // Return success information
	             return "TransferSuccess";
	         } else {
	             // Insufficient balance in the fromAccount
	             return "InsufficientFunds";
	         }
	     } else {
	         // Invalid account or password
	         return "InvalidCredentials";
	     }
	 }

	 
//	 @Transactional
//	    public boolean closeAccountTemporarily(int accountNumber, String password) {
//	        Bank bank = repository.findByAccountNumber(accountNumber);
//
//	        if (bank != null && bank.getPassword().equals(password)) {
//	            // Set a flag indicating temporary closure
//	            bank.setClosed(true);
//	            repository.save(bank);
//	            return true; // Account closed temporarily
//	        } else {
//	            return false; // Invalid account or password
//	        }
//	    }

}