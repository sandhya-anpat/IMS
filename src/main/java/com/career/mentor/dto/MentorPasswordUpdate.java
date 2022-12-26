package com.career.mentor.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MentorPasswordUpdate {
	
	@NotNull
	private String mentorEmail;
	
	@NotNull
	private String password;

}
