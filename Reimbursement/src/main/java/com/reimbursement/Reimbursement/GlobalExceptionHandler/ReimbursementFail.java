package com.reimbursement.Reimbursement.GlobalExceptionHandler;

public class ReimbursementFail extends RuntimeException{

	public ReimbursementFail() {
		super();
	}
	public ReimbursementFail(String message) {
		super(message);
	}
}
