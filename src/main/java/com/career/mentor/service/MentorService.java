package com.career.mentor.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.career.dto.ResponseDto;
import com.career.mentor.dto.MentorUpdateDto;
import com.career.mentor.entity.Mentor;

@Service
public interface MentorService {

	public List<Mentor> getAllMentor();

	 Mentor getMentorById(Long id);

	Mentor updateMentor(MentorUpdateDto mentorUpdateDto);

	String deleteMentor(Long mentorId);
		

}
