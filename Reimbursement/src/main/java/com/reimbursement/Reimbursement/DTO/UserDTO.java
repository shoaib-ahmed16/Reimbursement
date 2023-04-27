package com.reimbursement.Reimbursement.DTO;

import com.reimbursement.Reimbursement.Entity.User;

public class UserDTO {

	private int userId;
	
	private String firstname;
	
	private String lastName;
	
	private String email;
	
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDTO(int userId, String firstname, String lastName, String email, String password) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public UserDTO(User user) {
		super();
		this.userId = user.getUserId();
		this.firstname = user.getFirstname();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}
	
	public UserDTO() {
		
	}
}
