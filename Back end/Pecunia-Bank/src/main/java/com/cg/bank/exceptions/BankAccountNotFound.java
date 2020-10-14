package com.cg.bank.exceptions;

@SuppressWarnings("serial")
public class BankAccountNotFound extends RuntimeException {
	public BankAccountNotFound(String exception) {
        super(exception);

}
}