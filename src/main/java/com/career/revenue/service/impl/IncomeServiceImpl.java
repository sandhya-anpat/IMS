package com.career.revenue.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.career.constants.AppConstants;
import com.career.constants.IncomeCategory;
import com.career.revenue.dto.PaymentDto;
import com.career.revenue.entity.Income;
import com.career.revenue.repo.IncomeRepo;
import com.career.revenue.service.IncomeService;

@Service
public class IncomeServiceImpl implements IncomeService {
	
	@Autowired 
	private IncomeRepo incomeRepo;

	@Autowired
	private ModelMapper mapper;
	
	public String response;
	
	@Override
	public String saveIncomeDetails(PaymentDto paymentDto) {
		Income income = mapper.map(paymentDto, Income.class);
		if(IncomeCategory.MAIN_FEES == (paymentDto.getIncomeCategory())) {
			if(income.getTotalFees().equals(income.getPaidFees()))
				response = AppConstants.FEES_ALREADY_PAID;
			else {
				if((income.getPaidFees()+paymentDto.getAmount()) > income.getTotalFees()) {
					response = AppConstants.PAY_LIMIT_EXCEEDED;
				}
				else {
					income.setBalanceFees(income.getTotalFees() - (income.getPaidFees()+paymentDto.getAmount()));
				}
					
			}
			
			Income saveIncome = incomeRepo.save(income);
			if(saveIncome!=null) response = AppConstants.PAYMENT_SUCCESSFUL;
			else response = AppConstants.PAYMENT_FAILED;
			
			
			
		}
		
		return response;
	}
	
	

}
