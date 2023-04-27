package com.reimbursement.Reimbursement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ReimbursementPaid {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reimbursementPaidId;
	
	private String claimType;
	
	private String dateOfExpense;
	
	private double claimAmount;
	
	private double aprovedAmount;
	
	private double paidAmount;
	
	private String claimMonth;
	
	private int claimYear;
	
	private boolean paidStatus=true;
	
	public int getReimbursementPaidId() {
		return reimbursementPaidId;
	}

	public void setReimbursementPaidId(int reimbursementPaidId) {
		this.reimbursementPaidId = reimbursementPaidId;
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

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public double getAprovedAmount() {
		return aprovedAmount;
	}

	public void setAprovedAmount(double aprovedAmount) {
		this.aprovedAmount = aprovedAmount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
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

	public ReimbursementPaid(int reimbursementPaidId, String claimType, String dateOfExpense, double claimAmount,
			double aprovedAmount, double paidAmount, String claimMonth, int claimYear, boolean paidStatus) {
		super();
		this.reimbursementPaidId = reimbursementPaidId;
		this.claimType = claimType;
		this.dateOfExpense = dateOfExpense;
		this.claimAmount = claimAmount;
		this.aprovedAmount = aprovedAmount;
		this.paidAmount = paidAmount;
		this.claimMonth = claimMonth;
		this.claimYear = claimYear;
		this.paidStatus = paidStatus;
	}
	public ReimbursementPaid() {
		
	}
}
