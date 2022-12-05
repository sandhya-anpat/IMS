package com.career.student.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateDto {

	private Long id;
	
	@NotNull(message = "FirstName cannot be null")
	@Size(min = 3, message = "FirstName contains atleast 3 characters")
	private String firstName;
	
	@NotNull(message = "LastName cannot be null")
	@Size(min = 3, message = "LastName contains atleast 3 characters")
	private String lastName;
	
	@NotNull(message = "Email cannot be null")
	private String email;
	
	@NotNull(message = "MobileNumber cannot be null")
	@Size
	private String mobile;
	
	private Long mentorId;
	
//	@Column(name = "isContractSent", columnDefinition = "boolean default true")
//	private boolean isContractSent = true;
	
	@CreationTimestamp
	private LocalDateTime createdOn = LocalDateTime.now();
	
	@UpdateTimestamp
	private LocalDateTime updateOn = LocalDateTime.now();
	
//	@Column(name = "active", columnDefinition = "boolean default true")
//	private boolean active = true;
	
	@NotNull
	private String education;

	@NotNull
	private String passingYear;
	
//	private String mentor;

//	@Column(name = "isMentorOpted", columnDefinition = "boolean default false")
//	private boolean isMentorOpted = false;
//	
//	@NotNull
//	private Long incomeId;
	
//	@NotNull
//	private Long basePackage;
	
//	@Column(name = "formalContractRecived", columnDefinition = "boolean default false")
//	private boolean formalContractRecived = false;
//	
//	@Column(name = "formalContractGenerated", columnDefinition = "boolean default false")
//	private boolean formalContractGenerated = false;
//	
	@Column(name = "batchCode", columnDefinition = "varchar default false")
	private String batchCode = "SDE13";


}
