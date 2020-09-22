package com.cg.bank.models;

import java.util.Date;

public class Transaction {
	
	private long acc_num;
	private long payee_acc_num;
	private long amount;
	private long cheque_num;
	private String ifsc;
	private String bank_name;
	private Date cheque_issue_date;
	
	
	public long getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(long acc_num) {
		this.acc_num = acc_num;
	}
	public long getPayee_acc_num() {
		return payee_acc_num;
	}
	public void setPayee_acc_num(long payee_acc_num) {
		this.payee_acc_num = payee_acc_num;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getCheque_num() {
		return cheque_num;
	}
	public void setCheque_num(long cheque_num) {
		this.cheque_num = cheque_num;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}	
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public Date getCheque_issue_date() {
		return cheque_issue_date;
	}
	public void setCheque_issue_date(Date cheque_issue_date) {
		this.cheque_issue_date = cheque_issue_date;
	}
}
