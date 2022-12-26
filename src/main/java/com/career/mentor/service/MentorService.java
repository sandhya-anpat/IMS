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

	String registerMentor(RegisterMentorDto registerMentorDto);

	String loginMentor(LoginMentorDto loginMentorDto);

	String updateMentorPassword(MentorPasswordUpdate passwordUpdate);
		

}
