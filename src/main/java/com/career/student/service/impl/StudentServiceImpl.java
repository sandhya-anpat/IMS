package com.career.student.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.career.constants.AppConstants;
import com.career.exceptions.EmailAlreadyExistsException;
import com.career.student.dto.StudentPasswordUpdateDto;
import com.career.student.dto.StudentRegistrationDto;
import com.career.student.dto.StudentUpdateDto;
import com.career.student.entity.Student;
import com.career.student.repo.StudentRepo;
import com.career.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private ModelMapper mapper;
	
	private static String response;

	@Override
	public String saveStudent(StudentRegistrationDto registrationDto) throws EmailAlreadyExistsException {
		if (emailAlreadyExists(registrationDto.getEmail()).equals(AppConstants.EMAIL_ALREADY_EXISTS))
			throw new EmailAlreadyExistsException();
		else {
			if (studentRepo.save(mapper.map(registrationDto, Student.class)) != null)
				response = AppConstants.SAVE_SUCCESS;
			else
				response = AppConstants.SAVE_FAIURE;
		}
		return response;
	}

	@Override
	public Student updatePassword(StudentPasswordUpdateDto passwordUpdateDto) {
		List<Student> byEmail = studentRepo.findByEmail(passwordUpdateDto.getEmail());
		if (byEmail.isEmpty()) {
			// throw exception StudentNotFoundException
		}
		if (byEmail.size() > 1) {
			// inconsistent data
		}
		byEmail.get(0).setPassword(passwordUpdateDto.getPassword());
		Student updated = studentRepo.save(byEmail.get(0));
		return updated;
	}

//	@Override
//	public ResponseEntity<Book> patch(UUID id, Map<Object, Object> fields) {
//	Optional<Book> book studentRepo.findById(id);
//	if (book.isPresent()) {
//	fields.forEach((key, value) -> {
//	Field field = ReflectionUtils.findField(Book.class, (String) key);
//	field.setAccessible(true);
//	ReflectionUtils.setField(field, book.get(), value);
//	});
//	Book updated Book = bookService.saveOrUpdate(book.get());
//	updatedBook.add(linkTo(methodOn(Book Resource Impl.class).findById(updatedBook.getId())).withSelfRel());
//	updatedBook.add(linkTo(methodOn(Book Resource Impl.class).findAll()).withSelfRel());
//	return new ResponseEntity<>(updated Book, HttpStatus.OK);
//	}
//	return null;
//	}

	@Override
	public Student updateStudent(StudentUpdateDto studentUpdateDto) {
		Student entity = mapper.map(studentUpdateDto, Student.class);
		return studentRepo.save(entity);
	}

	@Override
	public String deleteStudent(Long id) {
		String message = AppConstants.DELETE_FAILURE;
		if (studentRepo.existsById(id)) {
			studentRepo.deleteById(id);
			message = AppConstants.DELETE_SUCCESS;
		}
		return message;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		if (studentRepo.existsById(id)) {
			return studentRepo.findById(id).get();
		}
		return null;
	}

	@Override
	public List<Student> getAllActiveStudents() {
		return studentRepo.findAllStudentByActiveTrue();
	}

	@Override
	public String emailAlreadyExists(String email) {
		String response = AppConstants.EMAIL_DOESNT_EXIST;
		List<Student> byEmail = studentRepo.findByEmail(email);
		if (byEmail.isEmpty())
			return response;
		else if (byEmail.size() > 0)
			response = AppConstants.EMAIL_ALREADY_EXISTS;
		return response;
	}

}
