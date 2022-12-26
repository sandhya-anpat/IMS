package com.career.mentor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.career.mentor.dto.LoginMentorDto;
import com.career.mentor.dto.MentorPasswordUpdate;
import com.career.mentor.dto.MentorUpdateDto;
import com.career.mentor.dto.RegisterMentorDto;
import com.career.mentor.entity.Mentor;

@Service
public interface MentorService {

	public List<Mentor> getAllMentor();

	 Mentor getMentorById(Long id);

	String updateMentor(MentorUpdateDto mentorUpdateDto);

	String deleteMentor(Long mentorId);
<<<<<<< HEAD
	
	String deleteMentorById(Long mentorId);
	
	List<Mentor> getAllActiveMentor();
=======

	String registerMentor(RegisterMentorDto registerMentorDto);

	String loginMentor(LoginMentorDto loginMentorDto);

	String updateMentorPassword(MentorPasswordUpdate passwordUpdate);
>>>>>>> 576498f9183fe513d62dc21f3b20d84e491fe487
		

}
