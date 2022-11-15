package com.career.revenue.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorSalaryDto {
	
	private Long mentorId;
	private LocalDateTime createdOn;
	private Long amount;
	private Long expenceId;
	
	
}
