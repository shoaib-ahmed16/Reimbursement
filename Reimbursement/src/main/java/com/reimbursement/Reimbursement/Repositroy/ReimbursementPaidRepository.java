package com.reimbursement.Reimbursement.Repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reimbursement.Reimbursement.Entity.ReimbursementPaid;

@Repository
public interface ReimbursementPaidRepository extends JpaRepository<ReimbursementPaid,Integer> {

}
