package com.reimbursement.Reimbursement.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reimbursement.Reimbursement.DTO.ReimbursementDTO;
import com.reimbursement.Reimbursement.Entity.Reimbursement;
import com.reimbursement.Reimbursement.GlobalExceptionHandler.ReimbursementDetailsNotFound;
import com.reimbursement.Reimbursement.Repositroy.ReimbursementRepository;
@Service
public class ReimbursementIntrImpl implements ReimbursementIntr {

	@Autowired
	private ReimbursementRepository reimbursementRepository;

	@Override
	public String addOrUpdateReimbursement(Reimbursement reb) {
		// TODO Auto-generated method stub
		reimbursementRepository.save(reb);
		return "Reimbursement Added Successfully.";
	}

	@Override
	public List<ReimbursementDTO> getAllReibursementDetails() {
		// TODO Auto-generated method stub
		List<Reimbursement> list =reimbursementRepository.findAll();
		List<ReimbursementDTO> returnList=new ArrayList<>();
		for(Reimbursement r:list)
				returnList.add(new ReimbursementDTO(r));
		return returnList;
	}

	@Override
	public List<Reimbursement> getAllReibursementDetailsByPaidStatus(boolean status) {
		// TODO Auto-generated method stub
		return reimbursementRepository.findByPaidStatus(status);
	}

	@Override
	public String deleteReibursment(Integer reimbursementId) {
		Optional<Reimbursement> find =reimbursementRepository.findById(reimbursementId);
		if(find.isPresent()) {
			reimbursementRepository.delete(find.get());
			return "Reimbursement is done!";
		}
		throw new ReimbursementDetailsNotFound("No record found for the Reimbursement");
	}
	
}
