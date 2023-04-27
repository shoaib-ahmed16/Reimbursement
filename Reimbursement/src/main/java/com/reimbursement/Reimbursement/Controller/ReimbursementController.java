package com.reimbursement.Reimbursement.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursement.Reimbursement.DTO.ReimbursementDTO;
import com.reimbursement.Reimbursement.DTO.ReimbursementPaidDTO;
import com.reimbursement.Reimbursement.DTO.UserDTO;
import com.reimbursement.Reimbursement.Entity.Reimbursement;
import com.reimbursement.Reimbursement.Entity.ReimbursementPaid;
import com.reimbursement.Reimbursement.Entity.User;
import com.reimbursement.Reimbursement.Services.MonthAndYearIntr;
import com.reimbursement.Reimbursement.Services.ReimbursementIntr;
import com.reimbursement.Reimbursement.Services.ReimbursementPaidIntr;
import com.reimbursement.Reimbursement.Services.UserIntr;

@RestController
@CrossOrigin
@RequestMapping(value="/reimbursement")
public class ReimbursementController {

	@Autowired
	private ReimbursementIntr reimbursementIntr;
	
	@Autowired
	private MonthAndYearIntr monthAndYearIntr;
	
	@Autowired
	private UserIntr userIntr;
	
	@Autowired
	private ReimbursementPaidIntr reimbursementPaidIntr;
	
	@PostMapping("/userRegister")
	public ResponseEntity<String> userRegister(@RequestBody User user)
	{
		return new ResponseEntity<String>(userIntr.addorUpdateUser(user),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/user")
	public ResponseEntity<String> deleterUser(@RequestBody Map<String,String> map){
		return new ResponseEntity<String>(userIntr.deleteUser(map.get("email")),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/userLogin")
	public ResponseEntity<UserDTO> userLogin(@RequestBody Map<String,String> map){
		return new ResponseEntity<UserDTO>(userIntr.getUser(map.get("email"),map.get("password")),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addOrUpdate")
	public ResponseEntity<String> addReimburseMent(@RequestBody Reimbursement reimbursement)
	{
		return new ResponseEntity<String>(reimbursementIntr.addOrUpdateReimbursement(reimbursement),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{reimbursementId}")
	public ResponseEntity<String> deleteReimbursementById(@PathVariable("reimbursementId") int reimbursementId){
		return new ResponseEntity<String>(reimbursementIntr.deleteReibursment(reimbursementId),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getSelectionMonth")
	public ResponseEntity<List<String>> getAndSelectMonth(){
		return new ResponseEntity<List<String>>(monthAndYearIntr.getAllMonthsOfYear(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allReimbursementDetails")
	public ResponseEntity<List<ReimbursementDTO>> getAllReimbursementDetails(){
		return new ResponseEntity<List<ReimbursementDTO>>(reimbursementIntr.getAllReibursementDetails(),HttpStatus.OK);
	}
	
	@PostMapping("/reimbursementPaid")
	public ResponseEntity<String> reimbursementPaid(@RequestBody ReimbursementPaid reimbursementPaid)
	{
		return new ResponseEntity<String>(reimbursementPaidIntr.paidReimbursement(reimbursementPaid),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allReimbursementPaidDetails")
	public ResponseEntity<List<ReimbursementPaidDTO>> getAllReimbursementPaidOrUnpaidDetails(){
		return new ResponseEntity<List<ReimbursementPaidDTO>>(reimbursementPaidIntr.getAllReimbursementPaidDetails(),HttpStatus.OK);
	}
	
	
}
