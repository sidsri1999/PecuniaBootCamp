package com.cg.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.bank.entities.Account;


@Repository
public interface AccountDao extends JpaRepository<Account, String> {
	@Query("select det from Account det where accountId=?1")
	Account selectById(@Param("c") String s1);
	
}
