package com.career.revenue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.career.constants.Category;
import com.career.revenue.dto.ElectricityDto;
import com.career.revenue.dto.MentorSalaryDto;
import com.career.revenue.dto.OthersDto;
import com.career.revenue.dto.RentDto;
import com.career.revenue.entity.Expences;

@Service
public interface ExpencesService {

	public String mentorSalary(MentorSalaryDto mentorSalary);

	public String rentExpences(RentDto rent);

	public String electricityExpences(ElectricityDto electricity);

	public String othersExpences(OthersDto others);

	List<Expences> getAllExpences();

	List<Expences> getAllExpencesByCategory(Category category);

}
