package com.reimbursement.Reimbursement.Services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MonthAndYearIntrImpl implements MonthAndYearIntr {

	@Override
	public List<String> getAllMonthsOfYear() {
		// TODO Auto-generated method stub
		String[] months = {"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
		return Arrays.asList(months);
	}
	
}

