package com.cg.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bank.entities.Account;

interface TransactionDAO extends JpaRepository<Account, Long>{

	Account getAccountByAcc_Num(Long acc_num);
		
}