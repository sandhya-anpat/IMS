package com.career.mentor.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.career.constants.AppConstants;
import com.career.exceptions.EmailAlreadyExistsException;
import com.career.exceptions.MentorIncorrectPassword;
import com.career.exceptions.MentorNotFoundException;
import com.career.mentor.dto.LoginMentorDto;
import com.career.mentor.dto.MentorPasswordUpdate;
import com.career.mentor.dto.MentorUpdateDto;
import com.career.mentor.dto.RegisterMentorDto;
import com.career.mentor.entity.Mentor;
import com.career.mentor.repo.MentorRepo;
import com.career.mentor.service.MentorService;

@Service
public class MentorServiceImpl implements MentorService {

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
		if (!mentorRepo.existsById(id))
			throw new MentorNotFoundException();
		else
			return mentorRepo.findById(id).get();
	}

	@Override
	public String updateMentor(MentorUpdateDto mentorUpdateDto) throws MentorNotFoundException { // throw MentorNotFoundException()
		Mentor entity = mapper.map(mentorUpdateDto, Mentor.class);
//		 return mentorRepo.save(entity);
		if (!mentorRepo.existsById(mentorUpdateDto.getMentorId())) {
			throw new MentorNotFoundException();
			
		} else {
			if (mentorRepo.save(entity) != null) {
				response = AppConstants.MENTOR_UPDATE_FAIL;
			} else {
				response = AppConstants.MENTOR_UPDATE_SUCCESS;
			}
		}

		return response;

	}

	@Override
	public String deleteMentor(Long mentorId) throws MentorNotFoundException { // throw MentorNotFoundException()
		if (!mentorRepo.existsById(mentorId)) {
			throw new MentorNotFoundException();
		} else {
			mentorRepo.deleteById(mentorId);
			response = AppConstants.DELETE_SUCCESS;
		}
		return response;
	}

	@Override
	public String registerMentor(RegisterMentorDto registerMentorDto) {

		List<Mentor> mentorByEmail = mentorRepo.findMentorByEmail(registerMentorDto.getMentorEmail());

		response = AppConstants.MENTOR_SAVE_SUCCESS;

		if (mentorByEmail.size() > 0)
			throw new EmailAlreadyExistsException();
		else {
			Mentor entity = mapper.map(registerMentorDto, Mentor.class);
			if (mentorRepo.save(entity) == null)
				response = AppConstants.MENTOR_SAVE_FAIL;
		}
		return response;
	}

	@Override
	public String loginMentor(LoginMentorDto loginMentorDto) {
		List<Mentor> findMentorEmail = mentorRepo.findMentorByEmail(loginMentorDto.getMentorEmail());
		if (findMentorEmail.size() == 0)
			throw new MentorNotFoundException();
		else {
			if (!loginMentorDto.getPassword().equals(findMentorEmail.get(0).getPassword()))
				throw new MentorIncorrectPassword();
			else
				response = AppConstants.MENTOR_LOGIN_SUCCESS;
//				response = AppConstants.MENTOR_LOGIN_FAIL;
		}
		return response;
	}

	@Override
	public String updateMentorPassword(MentorPasswordUpdate passwordUpdate) {
		List<Mentor> findMentorEmail = mentorRepo.findMentorByEmail(passwordUpdate.getMentorEmail());
		if (findMentorEmail.size() == 0)
			throw new MentorNotFoundException();
		else {
			Mentor entity = findMentorEmail.get(0);
			entity.setPassword(passwordUpdate.getPassword());
			if (mentorRepo.save(entity) == null)
				response = AppConstants.MENTOR_PASSWORD_UPDATE_FAIL;
			else
				response = AppConstants.MENTOR_PASSWORD_UPDATE_SUCCESSFUL;
		}

		return response;
	}

}
