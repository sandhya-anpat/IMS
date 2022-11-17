package com.career.revenue.service;

import org.springframework.stereotype.Service;

import com.career.revenue.dto.MentorSalaryDto;

@Service
public interface ExpencesService {

	public String mentorSalary(MentorSalaryDto mentorSalary);

}
