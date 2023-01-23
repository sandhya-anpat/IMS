package com.career.student.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.career.constants.AppConstants;
import com.career.exceptions.EmailAlreadyExistsException;
import com.career.exceptions.IncorrectPasswordException;
import com.career.exceptions.StudentNotFoundException;
import com.career.student.dto.LoginDto;
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
	public String loginStudent(LoginDto loginDto) throws StudentNotFoundException{
		List<Student> findByEmail = studentRepo.findByEmail(loginDto.getEmail());
		if(findByEmail.size()==0)
//			response = AppConstants.NOT_FOUND;
			throw new StudentNotFoundException();
		else if(findByEmail.size()==1)
			if(!loginDto.getPassword().equals(findByEmail.get(0).getPassword()))
//				response = AppConstants.INCORRECT_PASSWORD;
				throw new IncorrectPasswordException();
			else
				response = AppConstants.LOGIN_SUCCESS;
		return response;
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Override
	public String deleteStudentById(Long id) {
		
		if(!studentRepo.existsById(id))
			throw new StudentNotFoundException();
		else {
			Student byId = studentRepo.getById(id);
			byId.setActive(false);
			studentRepo.save(byId);
			response = AppConstants.DELETE_SUCCESS;
		}
		return response;
	}

	@Override
	public String updatePassword(StudentPasswordUpdateDto passwordUpdateDto) {
		List<Student> byEmail = studentRepo.findByEmail(passwordUpdateDto.getEmail());
		if (byEmail.isEmpty()) {
			throw new StudentNotFoundException();
		}
		if (byEmail.size() > 1) {
			// inconsistent data
			response = AppConstants.PASSWORD_UPDATE_FAILURE;
		}
		byEmail.get(0).setPassword(passwordUpdateDto.getPassword());
		Student updated = studentRepo.save(byEmail.get(0));
		
		response = AppConstants.PASSWORD_UPDATE_SUCCESS;
		
		return response;
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
	public String updateStudent(StudentUpdateDto studentUpdateDto) {
		Student entity = mapper.map(studentUpdateDto, Student.class);
		if(studentRepo.existsById(studentUpdateDto.getId())) {
			studentRepo.save(entity);
			if(studentRepo.save(entity) == null) {
				response = AppConstants.STUDENT_UPDATE_FAILURE;
			}
			else {
				response = AppConstants.STUDENT_UPDATE_FAILURE;
			}
		}
		else {
			response = AppConstants.STUDENT_NOT_FOUND;
		}
		
		return response;
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
