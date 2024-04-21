package com.BankApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BankApplication.model.BankModel;

@Repository
public interface BankRepo extends JpaRepository<BankModel, Integer> {

	BankModel findByAccountNumber(int accountNumber);

}
