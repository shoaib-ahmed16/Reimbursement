package com.reimbursement.Reimbursement.GlobalExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class ReimbursementExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorMessage> myErrorHandler(ReimbursementDetailsNotFound rdnf,WebRequest req)
	{
		ErrorMessage err = new ErrorMessage(rdnf.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ErrorMessage>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> myErrorHandler(UserNotFound rf,WebRequest req)
	{
		ErrorMessage err = new ErrorMessage(rf.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ErrorMessage>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> myErrorHandler(ReimbursementUpdateFail ruf,WebRequest req)
	{
		ErrorMessage err = new ErrorMessage(ruf.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ErrorMessage>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> myErrorHandler(IllegalArgumentException ie,WebRequest req)
	{
		ErrorMessage err = new ErrorMessage(ie.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ErrorMessage>(err,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorMessage> myErrorHandler(NullPointerException np,WebRequest req)
	{
		ErrorMessage err = new ErrorMessage(np.getMessage(),LocalDateTime.now(),req.getDescription(false));
		return new ResponseEntity<ErrorMessage>(err,HttpStatus.BAD_REQUEST);
	}
}
