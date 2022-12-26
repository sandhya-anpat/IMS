package com.career.mentor.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.career.mentor.entity.Mentor;
import com.career.student.entity.Student;

@Repository
public interface MentorRepo extends JpaRepository<Mentor, Long> {

	List<Mentor> findAllMentorByActiveTrue();
}
