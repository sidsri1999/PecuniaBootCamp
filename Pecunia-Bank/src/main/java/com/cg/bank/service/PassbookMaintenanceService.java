package com.cg.bank.service;

import java.util.Date;
import java.util.List;

import com.cg.bank.entities.Transaction;

public interface PassbookMaintenanceService {
	
public List<Transaction> updatePassbook(String accountId);
	
	public void updatelastUpdated(String accountId);

	public List<Transaction> accountSummary(String accountId, Date startDate, Date endDate);
	
	boolean accountValidation(String accountId);


}
