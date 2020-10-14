package com.cg.bank;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bank.entities.*;
import com.cg.bank.services.TransactionService;

@SpringBootTest
class TransactionsApplicationTests {

	@Autowired
	private TransactionService service;


	@Test
	public void DebitUsingSlipWithSufficientBalance() 
	{
		SlipTransactions slip = new SlipTransactions();
		slip.setAmount(5000);
		slip.setAccountNo("851990559412");
		slip.setTransactionType("Debit");

		String result=service.debitUsingSlip(slip);
		Assertions.assertEquals("transaction succesfull",result);
	}

	@Test
	public void DebitUsingSlipWithInSufficientBalance() 
	{
		SlipTransactions slip = new SlipTransactions();
		slip.setAmount(5000000);
		slip.setAccountNo("851990559412");
		slip.setTransactionType("Debit");

		String result=service.debitUsingSlip(slip);
		Assertions.assertEquals("Insufficient balance",result);
	}


	@Test
	public void DebitUsingChequeWithSufficientBalance() 
	{
		ChequeTransactions cheque = new ChequeTransactions();
		cheque.setAmount(5000);
		cheque.setBankName("Pecunia Bank");
		cheque.setChequeNo("456987");
		cheque.setIfsc("ASKA123456");
		cheque.setIssueDate(new Date(18-04-2020));
		cheque.setPayeeAccountNo("851990559411");
		cheque.setRecipientAccountNo("self");
		cheque.setTransactionType("debit");

		String result=service.debitUsingCheque(cheque);
		Assertions.assertEquals("transaction succesfull",result);
	}

	@Test
	public void DebitUsingChequeWithInSufficientBalance() 
	{
		ChequeTransactions cheque = new ChequeTransactions();
		cheque.setAmount(5000000);
		cheque.setBankName("Pecunia Bank");
		cheque.setChequeNo("456987");
		cheque.setIfsc("ASKA123456");
		cheque.setIssueDate(new Date(18-04-2020));
		cheque.setPayeeAccountNo("851990559411");
		cheque.setRecipientAccountNo("self");
		cheque.setTransactionType("debit");

		String result=service.debitUsingCheque(cheque);
		Assertions.assertEquals("Insufficient balance",result);
	}


	@Test
	public void CreditUsingSlipWithSufficientBalance() 
	{
		SlipTransactions slip = new SlipTransactions();
		slip.setAmount(5000);
		slip.setAccountNo("851990559412");
		slip.setTransactionType("Credit");

		String result=service.creditUsingSlip(slip);
		Assertions.assertEquals("transaction succesfull ",result);
	}

	@Test
	public void CreditUsingChequeWithSufficientBalance() 
	{
		ChequeTransactions cheque = new ChequeTransactions();
		cheque.setAmount(5000);
		cheque.setBankName("Indian Bank");
		cheque.setChequeNo("456987");
		cheque.setIfsc("ASKA123456");
		cheque.setIssueDate(new Date(18-04-2020));
		cheque.setPayeeAccountNo("851990559411");
		cheque.setRecipientAccountNo("851990559412");
		cheque.setTransactionType("credit");

		String result=service.creditUsingCheque(cheque);
		Assertions.assertEquals("transaction succesfull ",result);
	}

	@Test
	public void CreditUsingChequeWithInSufficientBalance() 
	{
		ChequeTransactions cheque = new ChequeTransactions();
		cheque.setAmount(5000000);
		cheque.setBankName("Indian Bank");
		cheque.setChequeNo("456987");
		cheque.setIfsc("ASKA123456");
		cheque.setIssueDate(new Date(18-04-2020));
		cheque.setPayeeAccountNo("851990559411");
		cheque.setRecipientAccountNo("851990559412");
		cheque.setTransactionType("credit");

		String result=service.creditUsingCheque(cheque);
		Assertions.assertEquals("Insufficient balance",result);
	}
}
