package com.career.student.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentPasswordUpdateDto {

	@NotNull(message = "Email cannot be null")
	private String email;
	
	@NotNull
	private String currentPassword;
	
	@NotNull
	private String newPassword;

	
}
