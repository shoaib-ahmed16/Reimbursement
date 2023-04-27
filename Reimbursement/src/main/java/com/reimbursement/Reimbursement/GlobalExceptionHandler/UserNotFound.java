package com.reimbursement.Reimbursement.GlobalExceptionHandler;

public class UserNotFound extends RuntimeException{

	public UserNotFound() {
		super();
	}
	public UserNotFound(String message) {
		super(message);
	}
}
	