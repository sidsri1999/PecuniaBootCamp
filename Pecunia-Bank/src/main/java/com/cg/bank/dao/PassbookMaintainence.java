package com.cg.bank.dao;


import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bank.entities.Account;
import com.cg.bank.entities.Transactions;

import java.util.List;


@Repository
public interface PassbookMaintainence extends JpaRepository<Account, String> {
	
	
	
	@Query("select t from Transactions t where accountId=?1 and t.transDate>=(select u.lastUpdated from Account u where accountId=?1) ")
	List<Transactions> updatePassbook(String accountId);
	
	
	@Modifying
	@Query("update Account set lastUpdated=?2 where  accountId=?1")
	void update(String accountId, Date date);
	
	
	@Query("select t from Transactions t where accountId=?1 and t.transDate>=?2 and t.transDate<=?3")
	List<Transactions> accountSummary(String accountId, Date startDate,Date endDate);
	
	
	@Query("select u from Account u where accountId=?1")
	Account get(String accountId);
	
	

}
