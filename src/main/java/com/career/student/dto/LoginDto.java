package com.career.student.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
	
	@NotNull(message = "Email cannot be null")
	private String email;
	
	@NotNull
	private String password;
	
}