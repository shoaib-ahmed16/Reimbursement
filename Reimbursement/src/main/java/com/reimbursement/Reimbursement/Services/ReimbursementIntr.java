package com.reimbursement.Reimbursement.Services;

import java.util.List;

import com.reimbursement.Reimbursement.DTO.ReimbursementDTO;
import com.reimbursement.Reimbursement.Entity.Reimbursement;

public interface ReimbursementIntr {

	public String addOrUpdateReimbursement(Reimbursement reb);
	public List<ReimbursementDTO> getAllReibursementDetails();
	public List<Reimbursement> getAllReibursementDetailsByPaidStatus(boolean status);
	public String deleteReibursment(Integer reimbursementId);
}
