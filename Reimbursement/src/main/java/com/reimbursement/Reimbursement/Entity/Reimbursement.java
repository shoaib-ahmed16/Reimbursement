package com.reimbursement.Reimbursement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reimbursement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reimbursementId;
	
	private String claimType;
	
	private String dateOfExpense;
	
	private double amount;
	
	private String claimMonth;
	
	private int claimYear;
	
	private boolean paidStatus=false;

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getDateOfExpense() {
		return dateOfExpense;
	}

	public void setDateOfExpense(String dateOfExpense) {
		this.dateOfExpense = dateOfExpense;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getClaimMonth() {
		return claimMonth;
	}

	public void setClaimMonth(String claimMonth) {
		this.claimMonth = claimMonth;
	}

	public int getClaimYear() {
		return claimYear;
	}

	public void setClaimYear(int claimYear) {
		this.claimYear = claimYear;
	}

	public boolean getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(boolean paidStatus) {
		this.paidStatus = paidStatus;
	}

	public Reimbursement(int reimbursementId, String claimType, String dateOfExpense, double amount, String claimMonth,
			int claimYear, boolean paidStatus) {
		super();
		this.reimbursementId = reimbursementId;
		this.claimType = claimType;
		this.dateOfExpense = dateOfExpense;
		this.amount = amount;
		this.claimMonth = claimMonth;
		this.claimYear = claimYear;
		this.paidStatus = paidStatus;
	}
	public Reimbursement() {
		super();
	}
	
	
}
