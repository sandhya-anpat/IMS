package com.career.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.career.exceptions.EmailAlreadyExistsException;
import com.career.student.dto.StudentPasswordUpdateDto;
import com.career.student.dto.StudentRegistrationDto;
import com.career.student.dto.StudentUpdateDto;
import com.career.student.entity.Student;

@Service
public interface StudentService {

	String saveStudent(StudentRegistrationDto registrationDto) throws EmailAlreadyExistsException;

	Student updatePassword(StudentPasswordUpdateDto passwordUpdateDto);

	Student updateStudent(StudentUpdateDto studentUpdateDto);

	String deleteStudent(Long id);

	List<Student> getAllStudents();

	Student getStudentById(Long id);

	List<Student> getAllActiveStudents();
		
	String emailAlreadyExists(String email);
}
