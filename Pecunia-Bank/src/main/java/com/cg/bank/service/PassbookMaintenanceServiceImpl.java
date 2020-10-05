package com.cg.bank.service;
import com.cg.bank.dao.PassbookMaintainence;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bank.entities.Account;

import com.cg.bank.entities.Transactions;

@Service
@Transactional
public class PassbookMaintenanceServiceImpl implements PassbookMaintenanceService {
	
	
	@Autowired
	private PassbookMaintainence dao;

	@Override
	public List<Transactions> updatePassbook(String accountId) {
		List<Transactions> result=dao.updatePassbook(accountId);
		updatelastUpdated(accountId);
		return result;	
	}

	@Override
	public void updatelastUpdated(String accountId) {
		long millis=System.currentTimeMillis();  
		Date date=new Date(millis); 
		 dao.update(accountId,date);

	}

	@Override
	public List<Transactions> accountSummary(String accountId, Date startDate, Date endDate) {
		return dao.accountSummary(accountId, startDate, endDate);
	}

	@Override
	public boolean accountValidation(String accountId) {
		 Account account=dao.get(accountId);
			if(account==null) {
				return false;
			}
			else {
				return true;
			}
	}

}
