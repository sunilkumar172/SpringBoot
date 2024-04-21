package com.BankApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankModel {
	
	@Id
	
	private int accountNumber;
	private String name;
	private String password;
	private double amount;
	private String address;
	private long mobileNo;
	
	
	public BankModel() {
		super();
	}


	public BankModel(int accountNumber, String name, String password, double amount, String address, long mobileNo) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.mobileNo = mobileNo;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


	@Override
	public String toString() {
		return "BankModel [accountNumber=" + accountNumber + ", name=" + name + ", password=" + password + ", amount="
				+ amount + ", address=" + address + ", mobileNo=" + mobileNo + "]";
	}
	
	
	
	
	
	

}
