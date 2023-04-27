package com.reimbursement.Reimbursement.Repositroy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reimbursement.Reimbursement.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	@Query
	public Optional<User> findByEmail(String email);
}
