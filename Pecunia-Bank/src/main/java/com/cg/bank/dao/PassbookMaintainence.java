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
	
	
	//fetching transactions till last updated
	@Query("select t from Transactions t where account_Id=?1 and t.transDate>=(select u.lastUpdated from Account u where account_Id=?1) ")
	List<Transactions> updatePassbook(String accountId);
	
	
    //updating last update
	@Modifying
	@Query("update Account set lastUpdated=?2 where  accountId=?1")
	void update(String accountId, Date date);
	
	
	@Query("select trans from Transactions trans where accountId=?1 and trans.transDate>=?2 and trans.transDate<=?3")
	List<Transactions> accountSummary(String accountId, Date startDate,Date endDate);
	
	//find by account
	@Query("select acc from Account acc where accountId=?1")
	Account get(String accountId);
	
	

}
