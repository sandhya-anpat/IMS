package com.career.revenue.service;

import org.springframework.stereotype.Service;

import com.career.revenue.dto.ElectricityDto;
import com.career.revenue.dto.MentorSalaryDto;
import com.career.revenue.dto.OthersDto;
import com.career.revenue.dto.RentDto;

@Service
public interface ExpencesService {

	public String mentorSalary(MentorSalaryDto mentorSalary);

	public String rentExpences(RentDto rent);

	public String electricityExpences(ElectricityDto electricity);

	public String othersExpences(OthersDto others);

}
