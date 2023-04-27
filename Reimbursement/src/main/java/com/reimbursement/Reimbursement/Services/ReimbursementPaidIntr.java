package com.reimbursement.Reimbursement.Services;

import java.util.List;

import com.reimbursement.Reimbursement.DTO.ReimbursementPaidDTO;
import com.reimbursement.Reimbursement.Entity.ReimbursementPaid;

public interface ReimbursementPaidIntr {

	public String paidReimbursement(ReimbursementPaid reimbursePaid);
	
	public List<ReimbursementPaidDTO> getAllReimbursementPaidDetails();
}
