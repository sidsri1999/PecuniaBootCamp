package com.cg.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bank.entities.LoanRequests;


@Repository
public interface LoanRequestDao extends JpaRepository<LoanRequests, String>{

	@Query("select e from LoanRequests e where accountId=:accountId")
	List<LoanRequests> selectById(String accountId);
	

}
