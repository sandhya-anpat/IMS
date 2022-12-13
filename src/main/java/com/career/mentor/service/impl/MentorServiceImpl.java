package com.career.mentor.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.career.constants.AppConstants;
import com.career.exceptions.EmailAlreadyExistsException;
import com.career.mentor.dto.MentorUpdateDto;
import com.career.mentor.dto.RegisterMentorDto;
import com.career.mentor.entity.Mentor;
import com.career.mentor.repo.MentorRepo;
import com.career.mentor.service.MentorService;

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
	public String updateMentor(MentorUpdateDto mentorUpdateDto) {
		 Mentor entity = mapper.map(mentorUpdateDto, Mentor.class);
//		 return mentorRepo.save(entity);
		 if(mentorRepo.existsById(mentorUpdateDto.getMentorId())) {
			 mentorRepo.save(entity);
			 if(mentorRepo.save(entity)!=null) {
					response = AppConstants.MENTOR_UPDATE_FAIL;
				 }
				 else {
					 response = AppConstants.MENTOR_UPDATE_SUCCESS;
				 }
		 }
		 else {
			 response = AppConstants.MENTOR_NOT_FOUND;
		 }
		 
		 return response;
		
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
	public String registerMentor(RegisterMentorDto registerMentorDto) {
		 
		List<Mentor> mentorByEmail = mentorRepo.findMentorByEmail(registerMentorDto.getMentorEmail());
				
		response = AppConstants.MENTOR_SAVE_SUCCESS;
		
		if(mentorByEmail.size()>0) 
			throw new EmailAlreadyExistsException();
		else {
			Mentor entity = mapper.map(registerMentorDto, Mentor.class);
			if(mentorRepo.save(entity)==null)
				response = AppConstants.MENTOR_SAVE_FAIL;
		}
		return response;
	}
	
	

}
