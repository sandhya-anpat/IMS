package com.career.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.career.student.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	@Query(value = "select std from student std where std.active = true")
	List<Student> getActiveStudents();
	
	List<Student> findAllStudentByActiveTrue();
	
	List<Student> findByEmail(String email);
}