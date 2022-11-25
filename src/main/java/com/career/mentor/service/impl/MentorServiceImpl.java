package com.career.mentor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.career.mentor.entity.Mentor;
import com.career.mentor.repo.MentorRepo;
import com.career.mentor.service.MentorService;

@Service
public class MentorServiceImpl implements MentorService   {
	
	@Autowired
	MentorRepo mentorRepo;
	
	@Override
	public List<Mentor> getAllMentor() {
		return mentorRepo.findAll();
	}

	@Override
	public Mentor getMentorById(Long id) {
		return mentorRepo.findById(id).get();
	}

}
