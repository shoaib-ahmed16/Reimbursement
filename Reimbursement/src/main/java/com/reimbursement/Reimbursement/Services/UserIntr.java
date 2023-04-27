package com.reimbursement.Reimbursement.Services;

import com.reimbursement.Reimbursement.DTO.UserDTO;
import com.reimbursement.Reimbursement.Entity.User;

public interface UserIntr {

	public String addorUpdateUser(User user);
	
	public UserDTO getUser(String email,String password);
	
	public String deleteUser(String email);
}
