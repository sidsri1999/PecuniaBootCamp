package com.cg.bank.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bank.dao.AccountDao;
import com.cg.bank.dao.LoanDisbursalDao;
import com.cg.bank.dao.LoanRequestDao;
import com.cg.bank.dao.TransactionsDao;
import com.cg.bank.entities.Account;
import com.cg.bank.entities.LoanDisbursal;
import com.cg.bank.entities.LoanRequests;
import com.cg.bank.entities.Transactions;
import com.cg.bank.exceptions.BankAccountNotFound;
import com.cg.bank.exceptions.IdNotFoundException;



@Service
public class BankLoanAppServiceImp implements BankLoanAppService {
	@Autowired
	private LoanRequestDao dao;
	@Autowired
	private AccountDao account;
	@Autowired
	private LoanDisbursalDao disburseDao;
	@Autowired
	private TransactionsDao transac;

	private Transactions transaction = new Transactions();
	private Random rand = new Random();
	private long millis = System.currentTimeMillis();
	private Date date = new Date(millis);
	
	// method used to request a loan, it takes the loan request object as the input
		// from the front end and checks whether the the customer have a
		// bank account on our bank and then loan will be approved or else an exception
		// is thrown

	public String loanRequest(LoanRequests loanreq) {
		String id = loanreq.getAccountId();
		Optional<Account> details = account.findById(id);
		if (details!=null) {
			dao.save(loanreq);
			return "Your Loan Request is successful";
	} else {

		 throw new BankAccountNotFound("No BankAccount found with " + loanreq.getAccountId()
				+ "\n You need to have an Bank Account to applay Loan");
	}

	}

	public ArrayList<LoanRequests> getAllRequests() {

		return (ArrayList<LoanRequests>) dao.findAll();
	}

	// This method used to check the approved loan requests on the particular
	// account number
	// It takes the bank account as the input and gives list of loans that are
	// accepted
	@Override
	public List<LoanDisbursal> getApproveLoans(String accountId) {
		LoanDisbursal disburse = new LoanDisbursal();
		List<LoanRequests> request = dao.selectById(accountId);
		@SuppressWarnings("rawtypes")
		Iterator itr = request.iterator();
		while (itr.hasNext()) {
			LoanRequests requests = (LoanRequests) itr.next();
			if (requests.getCreditScore() >= 670  && (!(disburseDao.existsById(requests.getLoanId())))) {
				disburse.setAccountId(requests.getAccountId());
				disburse.setCreditScore(requests.getCreditScore());

				disburse.setLoanId(requests.getLoanId());
				disburse.setLoanRoi(requests.getLoanRoi());
				disburse.setLoanStatus("Accepted");
				disburse.setLoanTenure(requests.getLoanTenure());
				disburse.setLoanType(requests.getLoanType());
				double interest = ((requests.getLoanAmount() * requests.getLoanTenure() * requests.getLoanRoi())
						/ (100 * 12));
				double emi = ((requests.getLoanAmount() + interest) / requests.getLoanTenure());
				
				disburse.setEmi(emi);
				disburse.setLoanAmount(requests.getLoanAmount() + interest);
				String accid=requests.getAccountId();
	      		Account details = account.getOne(accid);
	     		Double damount=details.getAmount() + requests.getLoanAmount();
				details.setAmount(damount);
				
			
					account.save(details);

				transaction.setAccountId(requests.getAccountId());
				transaction.setTransAmount(requests.getLoanAmount());
				transaction.setTransDate(date);
				transaction.setTransFrom("BANK");
				transaction.setTransId(rand.nextInt(1000));
				transaction.setTransTo(requests.getAccountId());
				transaction.setTransType(requests.getLoanType());
				transac.save(transaction);

				disburseDao.save(disburse);
			}

		}
		return (List<LoanDisbursal>) disburseDao.findAllAccepted(accountId);

		// This method used to check the rejected loan requests on the particular
		// account number
		// It takes the bank account as the input and gives list of loans that are
		// rejected based on the credit score
	}

	@Override
	public List<LoanDisbursal> getRejectedLoans(String accountId) {
		LoanDisbursal disburse = new LoanDisbursal();
		List<LoanRequests> request = dao.selectById(accountId);
		@SuppressWarnings("rawtypes")
		Iterator itr = request.iterator();
		while (itr.hasNext()) {
			LoanRequests requests = (LoanRequests) itr.next();

			if (requests.getCreditScore() < 670  && (!(disburseDao.existsById(requests.getLoanId())))) {
disburse.setAccountId(requests.getAccountId());
				disburse.setCreditScore(requests.getCreditScore());
				disburse.setLoanAmount(0);
				disburse.setLoanId(requests.getLoanId());
				disburse.setLoanRoi(requests.getLoanRoi());
				disburse.setLoanStatus("Rejected");
				disburse.setLoanTenure(requests.getLoanTenure());
				disburse.setLoanType(requests.getLoanType());
				disburse.setEmi(0);
				disburseDao.save(disburse);
			}

		}
		return (List<LoanDisbursal>) disburseDao.findAllRejected(accountId);

	}

	// This method used to pay the one emi of approved loan requests
	// It takes the loan disbursal as the input and debits the emi and updates in
	// the database
	@Override
	public String updateBalance(LoanDisbursal loandis) {

		if (loandis.getLoanTenure() > 0) {
			loandis.setLoanId(loandis.getLoanId());
			loandis.setAccountId(loandis.getAccountId());
			loandis.setCreditScore(loandis.getCreditScore());
			loandis.setEmi(loandis.getEmi());

			
			double amount = loandis.getLoanAmount() - loandis.getEmi();
			
			loandis.setLoanAmount(amount);
			loandis.setLoanRoi(loandis.getLoanRoi());
			loandis.setLoanStatus(loandis.getLoanStatus());
			loandis.setLoanTenure(loandis.getLoanTenure() - 1);
			loandis.setLoanType(loandis.getLoanType());

			transaction.setAccountId(loandis.getAccountId());
			transaction.setTransAmount(loandis.getEmi());
			transaction.setTransDate(date);
			transaction.setTransFrom(loandis.getAccountId());
			transaction.setTransId(rand.nextInt(1000));
			transaction.setTransTo("Pecunia Bank");
			transaction.setTransType("EMI");
			transac.save(transaction);
			Account details = account.selectById(loandis.getAccountId());
			details.setAmount(details.getAmount() - loandis.getEmi());
			account.save(details);

			disburseDao.save(loandis);

			return loandis.getLoanType() + " EMI Rs/- " + loandis.getEmi() + " from " + loandis.getAccountId()
					+ " account is paid!! ";
		} else {
			return "No pending loan!!!";
		}
	}
}

