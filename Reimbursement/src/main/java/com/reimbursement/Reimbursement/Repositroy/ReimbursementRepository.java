package com.reimbursement.Reimbursement.Repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reimbursement.Reimbursement.Entity.Reimbursement;

@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement,Integer> {

}
