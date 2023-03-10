package com.career.revenue.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.career.constants.Category;

public class CategoryDto {
	
	@NotNull
	private Long expenceId;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	

}
