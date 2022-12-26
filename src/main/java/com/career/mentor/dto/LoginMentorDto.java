package com.career.mentor.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginMentorDto {
	
	@NotNull(message = "Email cannot be null")
	private String mentorEmail;
	
	@NotNull
	private String password;

}
