package com.career.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.career.student.controller.StudentController;

@RestControllerAdvice(basePackageClasses = StudentController.class)
public class GlobalExceptionHandler {

	
}
