package com.career.revenue.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.career.constants.AppConstants;
import com.career.constants.Category;
import com.career.dto.ResponseDto;
import com.career.revenue.dto.ElectricityDto;
import com.career.revenue.dto.MentorSalaryDto;
import com.career.revenue.dto.OthersDto;
import com.career.revenue.dto.RentDto;
import com.career.revenue.entity.Expences;
import com.career.revenue.service.ExpencesService;

@RestController
@RequestMapping("expences")
public class ExpencesController {

	@Autowired
	ExpencesService expenceService;

	@PostMapping("/mentorsalary")
	public ResponseEntity<ResponseDto> mentorSalary(@RequestBody MentorSalaryDto mentorSalary) {

		if (AppConstants.MENTOR_SALARY_FAILED.equals(expenceService.mentorSalary(mentorSalary))) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.PAYMENT_FAILED,
					HttpStatus.BAD_REQUEST.value(), LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.PAYMENT_SUCCESSFUL,
					HttpStatus.OK.value(), LocalDateTime.now().toString()), HttpStatus.OK);
		}
	}

	@PostMapping("/rent")
	public ResponseEntity<ResponseDto> rentExpences(@RequestBody RentDto rent) {
		if (AppConstants.RENT_PAYMENT_FAILED.equals(expenceService.rentExpences(rent))) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.RENT_PAYMENT_FAILED,
					HttpStatus.BAD_REQUEST.value(), LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.RENT_PAYMENT_SUCCESSFUL,
					HttpStatus.OK.value(), LocalDateTime.now().toString()), HttpStatus.OK);
		}
	}

	@PostMapping("/electricity")
	public ResponseEntity<ResponseDto> electricityExpences(@RequestBody ElectricityDto electricity) {
		if (AppConstants.ELECTRICITY_PAYMENT_FAILED.equals(expenceService.electricityExpences(electricity))) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.ELECTRICITY_PAYMENT_FAILED,
					HttpStatus.BAD_REQUEST.value(), LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.ELECTRICITY_PAYMENT_SUCCESSFUL,
					HttpStatus.OK.value(), LocalDateTime.now().toString()), HttpStatus.OK);
		}

	}

	@PostMapping("/others")
	public ResponseEntity<ResponseDto> othersExpences(@RequestBody OthersDto others) {
		if (AppConstants.ELECTRICITY_PAYMENT_FAILED.equals(expenceService.othersExpences(others))) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.OTHERS_PAYMENT_FAILED,
					HttpStatus.BAD_REQUEST.value(), LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.OTHERS_PAYMENT_SUCCESSFUL,
					HttpStatus.OK.value(), LocalDateTime.now().toString()), HttpStatus.OK);
		}

	}

	@GetMapping("/getallexpence")
	public ResponseEntity<List<Expences>> getAllExpences() {
		return new ResponseEntity<List<Expences>>(expenceService.getAllExpences(), HttpStatus.OK);

	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Expences>> getAllExpencesByCategory(@PathVariable Category category) {
		return new ResponseEntity<List<Expences>>(expenceService.getAllExpencesByCategory(category), HttpStatus.OK);
	}

}
