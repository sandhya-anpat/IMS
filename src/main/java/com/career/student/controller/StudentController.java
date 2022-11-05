package com.career.student.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.career.constants.AppConstants;
import com.career.dto.ResponseDto;
import com.career.exceptions.EmailAlreadyExistsException;
import com.career.student.dto.StudentPasswordUpdateDto;
import com.career.student.dto.StudentRegistrationDto;
import com.career.student.dto.StudentUpdateDto;
import com.career.student.entity.Student;
import com.career.student.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("register")
	public ResponseEntity<ResponseDto> saveStudent(@RequestBody @Valid StudentRegistrationDto registrationDto)
			throws EmailAlreadyExistsException {
		if (studentService.saveStudent(registrationDto).equals(AppConstants.SAVE_FAIURE))
			return new ResponseEntity<>(new ResponseDto(AppConstants.SAVE_FAIURE, HttpStatus.BAD_REQUEST.value(),
					LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(
				new ResponseDto(AppConstants.SAVE_SUCCESS, HttpStatus.CREATED.value(), LocalDateTime.now().toString()),
				HttpStatus.CREATED);
	}

	@PatchMapping("updatePassword")
	public ResponseEntity<ResponseDto> updatePassword(@RequestBody StudentPasswordUpdateDto passwordUpdateDto) {
		studentService.updatePassword(passwordUpdateDto);
		return new ResponseEntity<>(new ResponseDto(AppConstants.PASSWORD_UPDATE_SUCCESS, HttpStatus.OK.value(),
				LocalDateTime.now().toString()), HttpStatus.OK);
	}

	@PutMapping("updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody StudentUpdateDto studentUpdateDto) {
		return new ResponseEntity<>(studentService.updateStudent(studentUpdateDto), HttpStatus.OK);
	}

	@GetMapping("all")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.FOUND);
	}

	@GetMapping("active")
	public ResponseEntity<List<Student>> getAllActiveStudents() {
		return new ResponseEntity<>(studentService.getAllActiveStudents(), HttpStatus.FOUND);
	}

	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.FOUND);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ResponseDto> deleteStudent(@PathVariable Long id) {
		String response = studentService.deleteStudent(id);
		if (response.equals(AppConstants.DELETE_SUCCESS))
			return new ResponseEntity<>(
					new ResponseDto(AppConstants.DELETE_SUCCESS, HttpStatus.OK.value(), LocalDateTime.now().toString()),
					HttpStatus.OK);
		return new ResponseEntity<>(
				new ResponseDto(AppConstants.NOT_FOUND, HttpStatus.NOT_FOUND.value(), LocalDateTime.now().toString()),
				HttpStatus.NOT_FOUND);
	}
}
