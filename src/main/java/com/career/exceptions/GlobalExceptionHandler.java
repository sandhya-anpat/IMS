package com.career.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.career.constants.AppConstants;
import com.career.dto.ResponseDto;
import com.career.mentor.controller.MentorController;
import com.career.student.controller.StudentController;

@RestControllerAdvice(basePackageClasses = {StudentController.class, MentorController.class})
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ResponseDto> studentNotFoundExceptionHandler() {
		return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.STUDENT_NOT_FOUND,
				HttpStatus.NOT_FOUND.value(), LocalDateTime.now().toString()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IncorrectPasswordException.class)
	public ResponseEntity<ResponseDto> incorrectPasswordExceptionHandler() {
		return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.INCORRECT_PASSWORD,
				HttpStatus.BAD_REQUEST.value(), LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ResponseDto> emailAlreadyExistsExceptionHandler(){
		return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.EMAIL_ALREADY_EXISTS, 
				HttpStatus.BAD_REQUEST.value(),LocalDateTime.now().toString()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MentorNotFoundException.class)
	public ResponseEntity<ResponseDto> mentorNotFoundExceptionHandler(){
		return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.MENTOR_NOT_FOUND, 
				HttpStatus.BAD_REQUEST.value(),LocalDateTime.now().toString()),HttpStatus.BAD_REQUEST);
	}
}
