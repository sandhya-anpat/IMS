package com.career.revenue.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.career.constants.AppConstants;
import com.career.dto.ResponseDto;
import com.career.revenue.dto.PaymentDto;
import com.career.revenue.service.IncomeService;

@RestController
@RequestMapping("income")
public class IncomeController {

	@Autowired
	IncomeService incomeService;

	@PostMapping("payment")
	public ResponseEntity<ResponseDto> saveIncomeDetails(@RequestBody PaymentDto paymentDto) {
		if (AppConstants.PAYMENT_FAILED.equals(incomeService.saveIncomeDetails(paymentDto)))
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.PAYMENT_FAILED,
					HttpStatus.BAD_REQUEST.value(), LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
		else 
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.PAYMENT_SUCCESSFUL,
					HttpStatus.OK.value(), LocalDateTime.now().toString()), HttpStatus.OK);
	}
}
