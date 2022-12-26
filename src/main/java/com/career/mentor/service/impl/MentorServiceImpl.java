package com.career.mentor.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.career.constants.AppConstants;
import com.career.exceptions.MentorNotFoundException;
import com.career.exceptions.StudentNotFoundException;
import com.career.mentor.dto.MentorUpdateDto;
import com.career.mentor.entity.Mentor;
import com.career.mentor.repo.MentorRepo;
import com.career.mentor.service.MentorService;
import com.career.student.entity.Student;

@Service
public class MentorServiceImpl implements MentorService   {
	
	@Autowired
	MentorRepo mentorRepo;
	
	@Autowired	
	private ModelMapper mapper;
	
	private static String response;
	
	@Override
	public List<Mentor> getAllMentor() {
		return mentorRepo.findAll();
	}

	@Override
	public Mentor getMentorById(Long id) {
		return mentorRepo.findById(id).get();
	}

	@Override
	public Mentor updateMentor(MentorUpdateDto mentorUpdateDto) {
		 Mentor entity = mapper.map(mentorUpdateDto, Mentor.class);
		 return mentorRepo.save(entity);
		
	}

	@Override
	public String deleteMentor(Long mentorId) {
		if(mentorRepo.existsById(mentorId)) {
				 mentorRepo.deleteById(mentorId);
			 	 response = AppConstants.DELETE_SUCCESS;
		}
		else
			response = AppConstants.DELETE_FAILURE;
		return response;
	}
	
	@Override
	public String deleteMentorById(Long mentorId) {
		Mentor mentor = mentorRepo.findById(mentorId).get();
		if(!mentorRepo.existsById(mentorId))
			throw new MentorNotFoundException();
		else {
			
			 if(mentor.getActive()) {
				// Mentor byId = mentorRepo.getById(mentorId);
				mentor.setActive(false);
			     mentorRepo.save(mentor);
			     response = AppConstants.DELETE_SUCCESS;
			 }else
				 throw new MentorNotFoundException();
		}
		
		return response;
	}
	
	public List<Mentor> getAllActiveMentor() {
		return mentorRepo.findAllMentorByActiveTrue();
	}
	

}
