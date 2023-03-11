package com.career.revenue.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorSalaryDto {
	
	@NotNull
	private Long mentorId;
	@CreationTimestamp
	private LocalDateTime createdOn;
	@NotNull
	private Long amount;
	
	
}
