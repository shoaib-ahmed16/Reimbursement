package com.reimbursement.Reimbursement.DTO;

import com.reimbursement.Reimbursement.Entity.Reimbursement;

public class ReimbursementDTO {

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

	public boolean isPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(boolean paidStatus) {
		this.paidStatus = paidStatus;
	}

	public ReimbursementDTO(int reimbursementId, String claimType, String dateOfExpense, double amount, String claimMonth,
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
	public ReimbursementDTO() {
		super();
	}
	
	public ReimbursementDTO(Reimbursement reimbursement) {
		super();
		this.reimbursementId = reimbursement.getReimbursementId();
		this.claimType =reimbursement.getClaimType();
		this.dateOfExpense = reimbursement.getDateOfExpense();
		this.amount = reimbursement.getAmount();
		this.claimMonth = reimbursement.getClaimMonth();
		this.claimYear = reimbursement.getClaimYear();
		this.paidStatus =reimbursement.getPaidStatus();
	}
	
}
