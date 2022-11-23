package com.career.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.career.constants.AppConstants;
import com.career.dto.ResponseDto;
import com.career.student.controller.StudentController;

@RestControllerAdvice(basePackageClasses = StudentController.class)
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ResponseDto> studentNotFoundExceptionHandler() {
		return new ResponseEntity<ResponseDto>(
				new ResponseDto(AppConstants.NOT_FOUND, HttpStatus.NOT_FOUND.value(), LocalDateTime.now().toString()),
				HttpStatus.NOT_FOUND);
	}
}
