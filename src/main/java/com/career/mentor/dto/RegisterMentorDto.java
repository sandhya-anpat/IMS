package com.career.mentor.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMentorDto {
	
	@NotNull
	private Long mentorId;
	
	@NotNull
	private String mentorName;
	
	@NotNull
	private String mentorEmail;
	
	
	@Column(name = "batchCode", columnDefinition = "varchar default false")
	private String batchCode = "SDE13";

}
