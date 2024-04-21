package com.BankApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BankApplication.model.BankModel;
import com.BankApplication.service.BankService;
import com.BankApplication.service.BankServiceImp;

@Controller
public class BankController {

	@Autowired
	private BankService bankService;
	
	
	@RequestMapping("/")
	public String HomePage() {
		return "Home";
	}
	
	@RequestMapping("/newAccount")
		public String newAccount() {
		return "newAccount";
	}
	
	@RequestMapping("/processNewAccount")
	public String processNewAccount(
			@RequestParam int accountNumber,
			@RequestParam String name,
			@RequestParam String password,
			@RequestParam double amount,
			@RequestParam String address,
			@RequestParam long mobileNo,
			ModelMap model) {

		BankModel bank = new BankModel();
		bank.setAccountNumber(accountNumber);
		bank.setName(name);
		bank.setPassword(password);
		bank.setAmount(amount);
		bank.setAddress(address);
		bank.setMobileNo(mobileNo);

		boolean isSaved = bankService.saveUser(bank);

		// Check the result of the save operation
		if (isSaved) {
			// Redirect to a success page
			model.addAttribute("message", "Welcome to SDFC Family");
			return "Success";
		} else {
			// Redirect to a failure page
			model.addAttribute("errorMessage", "Failed to create an account. Please try again.");
			return "failed";
		}
	}
	@RequestMapping("/balance")
	public String balance() {
		return "balance";
	}
	
	@RequestMapping("/processCheckBalance")
	public String processCheckBalance(
			@RequestParam int accountNumber,
			@RequestParam String password,
			ModelMap model) {

		// Call the service to check the balance
		BankModel bank = bankService.checkBalance(accountNumber, password);

		if (bank != null) {
			// Display information if the account is valid
			model.addAttribute("name", bank.getName());
			model.addAttribute("accountNumber", bank.getAccountNumber());
			model.addAttribute("balance", bank.getAmount());
			return "CheckBalanceResult";
		} else {
			// Display an error message
			model.addAttribute("errorMessage", "Invalid account number or password. Please try again.");
			return "CheckBalanceResult";
		}
	}
    
	@RequestMapping("/transfer")
	public String transfer() {
		return "transfer";
	}
	
	@RequestMapping("/processTransfer")
	public String processTransfer(
			@RequestParam int fromAccount,
			@RequestParam String password,
			@RequestParam double amount,
			@RequestParam int toAccount,
			ModelMap model) {

		String transferResult = bankService.transfer(fromAccount, password, amount, toAccount);

		switch (transferResult) {
		case "TransferSuccess":
			// Display success message
			model.addAttribute("message", "Transfer successful!");
			return "TransferSuccess"; // Create a JSP file for displaying the success message

		case "InvalidCredentials":
			// Display invalid credentials message
			model.addAttribute("errorType", "InvalidCredentials");
			model.addAttribute("errorMessage", "Invalid account or password. Please try again.");
			return "TransferError"; // Create a JSP file for displaying the error message

		case "InsufficientFunds":
			// Display insufficient funds message
			model.addAttribute("errorType", "InsufficientFunds");
			model.addAttribute("errorMessage", "Insufficient funds for the transfer.");
			return "TransferError"; // Create a JSP file for displaying the error message

		case "InvalidTransferAmount":
			// Display invalid transfer amount message
			model.addAttribute("errorType", "InvalidTransferAmount");
			model.addAttribute("errorMessage", "Invalid transfer amount. Please enter a positive value.");
			return "TransferError"; // Create a JSP file for displaying the error message

		default:
			// Handle other cases if needed
			model.addAttribute("errorType", "UnexpectedError");
			model.addAttribute("errorMessage", "An unexpected error occurred.");
			return "TransferError"; // Create a JSP file for displaying the error message
		}
	}
	@RequestMapping("/withdraw")
	public String withdraw() {
		return "withdraw";
	}
	
	@RequestMapping("/processWithdraw")
	public String processWithdraw(
			@RequestParam int accountNumber,
			@RequestParam String name,
			@RequestParam String password,
			@RequestParam double balance,
			ModelMap model) {

		// Call the service to process the withdrawal
		BankModel updatedBank = bankService.withdraw(accountNumber, name, password, balance);

		if (updatedBank != null) {
			// Display success message
			model.addAttribute("accountNumber", updatedBank.getAccountNumber());
			model.addAttribute("name", updatedBank.getName());
			model.addAttribute("remainingBalance", updatedBank.getAmount());
			return "WithdrawSuccess"; // Create a JSP file for displaying the success message
		} else {
			// Display an error message
			model.addAttribute("errorMessage", "Invalid withdrawal. Please check your inputs.");  

			// You can add more information about the error type
			model.addAttribute("errorType", "InvalidWithdrawal");

			return "WithdrawError"; // Create a JSP file for displaying the error message
		}
	}
	
	@RequestMapping("/deposit")
	public String deposit() {
		return "deposit";
	}
	
	@RequestMapping("/processDeposit")
	public String processDeposit(
			@RequestParam int accountNumber,
			@RequestParam String password,
			@RequestParam double balance,
			ModelMap model) {

		// Call the service to process the deposit
		boolean depositSuccess = bankService.deposit(accountNumber, password, balance);

		if (depositSuccess) {
			// Display success message
			model.addAttribute("message", "Deposit successful!");
			return "DepositSuccess"; // Create a JSP file for displaying the success message
		} else {
			// Display an error message
			model.addAttribute("errorMessage", "Invalid account number or password. Please try again.");
			return "DepositError"; // Create a JSP file for displaying the error message
		}
	}
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
}
