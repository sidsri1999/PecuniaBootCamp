package com.cg.bank.services;

import java.util.ArrayList;
import java.util.List;

import com.cg.bank.entities.LoanDisbursal;
import com.cg.bank.entities.LoanRequests;

public interface BankLoanAppService {
	public String loanRequest(LoanRequests loanreq);
	public ArrayList<LoanRequests> getAllRequests();
	public  List<LoanDisbursal> getApproveLoans(String accountId);
	public List<LoanDisbursal> getRejectedLoans(String accountId);
	public String updateBalance(LoanDisbursal loandis);

}
