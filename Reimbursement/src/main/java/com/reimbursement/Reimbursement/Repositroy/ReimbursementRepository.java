package com.reimbursement.Reimbursement.Repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reimbursement.Reimbursement.Entity.Reimbursement;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement,Integer> {

	@Query
	public List<Reimbursement> findByPaidStatus(boolean check);
}
