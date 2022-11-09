package com.career.revenue.service;

import org.springframework.stereotype.Service;

import com.career.revenue.dto.PaymentDto;

@Service
public interface IncomeService  {

	public String saveIncomeDetails(PaymentDto paymentDto);

}
