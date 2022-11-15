package com.career.revenue.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.career.constants.AppConstants;
import com.career.dto.ResponseDto;
import com.career.revenue.dto.MentorSalaryDto;
import com.career.revenue.service.ExpencesService;

@RestController
@RequestMapping("expences")
public class ExpencesController {

	@Autowired
	ExpencesService expenceService;

	public ResponseEntity<ResponseDto> mentorSalary(@RequestBody MentorSalaryDto mentorSalary){
		
		if(AppConstants.MENTOR_SALARY_FAILED.equals(expenceService.mentorSalary(mentorSalary))) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.PAYMENT_FAILED, HttpStatus.BAD_REQUEST.value(), LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.PAYMENT_SUCCESSFUL, HttpStatus.OK.value(), LocalDateTime.now().toString()), HttpStatus.OK);

		}
	}
}
