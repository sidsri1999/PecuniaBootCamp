package com.cg.bank.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.bank.entities.Account;
import com.cg.bank.entities.Customer;


public interface AccountManagementDao extends JpaRepository<Customer,Integer>{

	
	@Query("select f from Customer f where account_Id=?1")
	Customer findByAccountId(String accountId);
	
	
	@Modifying
	@Query("update Customer SET customer_Name=?2,contactNumber=?3,address=?4 where account_Id=?1")
	void updateAccount(String accountId, String customerName, String contactNumber, String address);
	
	
	@Modifying
	@Query("delete from Account e where account_Id=?1")
	void deleteAccount(String accountId);
	
	
	@Modifying
	@Query("delete from Customer e where account_Id=?1")
	void deletecustomer(String accountId);


	@Query("select det from Account det where accountId=?1")
	Account selectById(@Param("c") String s1);
	
	


	
	
	


}
