package com.reimbursement.Reimbursement.GlobalExceptionHandler;

public class ReimbursementDetailsNotFound extends RuntimeException {

	public ReimbursementDetailsNotFound(){
		super();
	}
	public ReimbursementDetailsNotFound(String message){
		super(message);
	}
}

