package com.reimbursement.Reimbursement.Services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.reimbursement.Reimbursement.DTO.Months;

@Service
public class MonthAndYearIntrImpl implements MonthAndYearIntr {

	@Override
	public List<Months> getAllMonthsOfYear() {
		// TODO Auto-generated method stub
		Months[] months = {new Months("January"),new Months("Febuary"),new Months("March"),new Months("April"),new Months("May"),new Months("June"),new Months("July"),new Months("August"),new Months("September"),new Months("October"),new Months("November"),new Months("December")};
		return Arrays.asList(months);
	}
	
}

