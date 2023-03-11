package com.career.mentor.dto;

import java.time.LocalDate;

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
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private LocalDate dob;
	
	@NotNull
	private LocalDate dateOfJoining;
	
	@NotNull
	private String address;
	
	@NotNull
	private String experience;
	
	@NotNull
	private String qualification;
	
	@NotNull
	private String mentorEmail;
	
	@NotNull
	private String password;
	
	@NotNull
	private String gender;
	
	@NotNull
	private Long contactNo;
	
	
	@Column(name = "batchCode", columnDefinition = "varchar default false")
	private String batchCode = "SDE13";

}
