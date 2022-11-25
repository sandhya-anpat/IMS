package com.career.mentor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.career.dto.ResponseDto;
import com.career.mentor.entity.Mentor;
import com.career.mentor.service.MentorService;

@RestController
@RequestMapping("mentor")
public class MentorController {
	
	@Autowired
	MentorService mentorService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Mentor>> getAllMentor(){
		return new ResponseEntity<List<Mentor>>(mentorService.getAllMentor(), HttpStatus.FOUND);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Mentor> getMentorById(@PathVariable Long id){
		return new ResponseEntity<Mentor>(mentorService.getMentorById(id), HttpStatus.FOUND);
	}
	
}
