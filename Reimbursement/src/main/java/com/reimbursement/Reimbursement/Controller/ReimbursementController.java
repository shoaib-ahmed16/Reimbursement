package com.reimbursement.Reimbursement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursement.Reimbursement.DTO.Months;
import com.reimbursement.Reimbursement.DTO.ReimbursementDTO;
import com.reimbursement.Reimbursement.Entity.Reimbursement;
import com.reimbursement.Reimbursement.Services.MonthAndYearIntr;
import com.reimbursement.Reimbursement.Services.ReimbursementIntr;

@RestController
public class ReimbursementController {

	@Autowired
	private ReimbursementIntr reimbursementIntr;
	
	@Autowired
	private MonthAndYearIntr monthAndYearIntr;
	
	@PostMapping("/reimbursement/addOrUpdate")
	public ResponseEntity<String> addReimburseMent(@RequestBody Reimbursement reimbursement)
	{
		return new ResponseEntity<String>(reimbursementIntr.addOrUpdateReimbursement(reimbursement),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAndselectMonth")
	public ResponseEntity<List<Months>> getAndSelectMonth(){
		return new ResponseEntity<List<Months>>(monthAndYearIntr.getAllMonthsOfYear(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allReimbursementDetails")
	public ResponseEntity<List<ReimbursementDTO>> getAllReimbursementDetails(){
		return new ResponseEntity<List<ReimbursementDTO>>(reimbursementIntr.getAllReibursementDetails(),HttpStatus.OK);
	}
}
