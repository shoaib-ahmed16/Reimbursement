package com.reimbursement.Reimbursement.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reimbursement.Reimbursement.DTO.UserDTO;
import com.reimbursement.Reimbursement.Entity.User;
import com.reimbursement.Reimbursement.GlobalExceptionHandler.UserNotFound;
import com.reimbursement.Reimbursement.Repositroy.UserRepository;

@Service
public class UserIntrImpl  implements UserIntr{

	@Autowired
	private UserRepository userRepo;

	@Override
	public String addorUpdateUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(user.getPassword());
		userRepo.save(user);
		return "User added Successful!";
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public UserDTO getUser(String email, String password) {
		// TODO Auto-generated method stub
		Optional<User> userFind =userRepo.findByEmail(email);
		if(userFind.isPresent())
		{
			User user =userFind.get();
			if(user.getPassword().equals(password))
			{
				UserDTO userOnly =new UserDTO();
				userOnly.setEmail(email);
				userOnly.setFirstname(user.getFirstname());
				userOnly.setLastName(user.getLastName());
				return userOnly;
			}
			else
				throw new UserNotFound("User Email id or Password is Invalid Or incorrect!");
		}
		throw new UserNotFound("User is not register with the email Id");
	}

	@Override
	public String deleteUser(String email) {
		// TODO Auto-generated method stub
		Optional<User> userFind =userRepo.findByEmail(email);
		if(userFind.isPresent())
		{
			userRepo.delete(userFind.get());
			return "User is deleted!";
		}
		else 
			throw new UserNotFound("User not found");
	}
}
