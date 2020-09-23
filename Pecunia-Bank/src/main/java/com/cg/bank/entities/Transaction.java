package com.cg.bank.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Transaction {
	@Id
	@GeneratedValue
	private Long transactionId;
	private Date transDate;
	
	private Long acc_num;
	private Long payee_acc_num;
	private Double amount;
	private Long cheque_num;
	private String ifsc;
	private String bank_name;
	private Date cheque_issue_date;
	
	public Long getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(Long acc_num) {
		this.acc_num = acc_num;
	}
	public Long getPayee_acc_num() {
		return payee_acc_num;
	}
	public void setPayee_acc_num(Long payee_acc_num) {
		this.payee_acc_num = payee_acc_num;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Long getCheque_num() {
		return cheque_num;
	}
	public void setCheque_num(Long cheque_num) {
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
	
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	
}
