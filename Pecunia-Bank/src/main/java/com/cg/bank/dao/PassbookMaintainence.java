package com.cg.bank.dao;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.bank.entities.Account;
import com.cg.bank.entities.Transaction;

import java.util.List;



public interface PassbookMaintainence extends JpaRepository<Account, String> {
	
	@Query("select t from Transaction t where acc_num=?1 and t.transDate>=(select u.passbook_last_updated from Account u where acc_num=?1) ")
	List<Transaction> updatePassbook(String accountId);
	
	
	@Modifying
	@Query("update Account set passbook_last_updated=?2 where  acc_num=?1")
	void update(String acc_num,  Date date);
	
	
	@Query("select t from Transaction t where acc_num=?1 and t.transDate>=?2 and t.transDate<=?3")
	List<Transaction> accountSummary(String accountId,  Date startDate, Date endDate);
	
	

}
