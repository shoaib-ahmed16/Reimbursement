package com.reimbursement.Reimbursement.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reimbursement.Reimbursement.DTO.ReimbursementPaidDTO;
import com.reimbursement.Reimbursement.Entity.Reimbursement;
import com.reimbursement.Reimbursement.Entity.ReimbursementPaid;
import com.reimbursement.Reimbursement.Repositroy.ReimbursementPaidRepository;

@Service
public class ReimbursementPaidIntrImpl implements ReimbursementPaidIntr {

	@Autowired
	private ReimbursementPaidRepository reimbursementPaidRepo;

	@Autowired
	private ReimbursementIntr reimbursementIntr;
	
	@Override
	public String paidReimbursement(ReimbursementPaid reimbursePaid) {
		reimbursementPaidRepo.save(reimbursePaid);
		return "Reimbursement Paid SuccessFully!";
	}

	@Override
	public List<ReimbursementPaidDTO> getAllReimbursementPaidDetails() {
		// TODO Auto-generated method stub
		List<Reimbursement> listOfUnpaid=reimbursementIntr.getAllReibursementDetailsByPaidStatus(false);
		List<ReimbursementPaidDTO> list =new ArrayList<>();
		for(Reimbursement r:listOfUnpaid)
		{
			list.add(new ReimbursementPaidDTO(r));
		}
		List<ReimbursementPaid> listPaid=reimbursementPaidRepo.findAll();
		for(ReimbursementPaid r:listPaid)
		{
			list.add(new ReimbursementPaidDTO(r));
		}
		return list;
	}
}
