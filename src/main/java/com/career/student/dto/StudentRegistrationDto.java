package com.career.student.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistrationDto {

	@NotNull(message = "First name cannot be null")
	@Size(min = 3, message = "Firstname should contain atleast 3 characters")
	private String firstName;
	
	@NotNull(message = "Last name cannot be null")
	@Size(min = 3, message = "Lastname should contain atleast 3 characters")
	private String lastName;
	
	@NotNull(message = "Email cannot be null")
	private String email;
	
	@Size(min = 10, max = 10, message = "Mobile number should contain 10 digits only")
	private String mobile;
	
	@NotNull(message = "Education cannot be null")
	private String education;
	
	@NotNull(message = "Passing Year cannot be null")
	private String passingYear;
	
	@NotNull(message = "Base Package cannot be null")
	private Long basePackage;
}
