package com.reimbursement.Reimbursement.GlobalExceptionHandler;

public class ReimbursementUpdateFail extends RuntimeException {
	
	public ReimbursementUpdateFail() {
		super();
	}
	public ReimbursementUpdateFail(String message) {
		super(message);
	}
}
