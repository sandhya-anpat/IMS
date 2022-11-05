package com.career.student.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "Firstname should contain atleast 3 characters")
	private String firstName;
	
	@NotNull
	@Size(min = 3, message = "Lastname should contain atleast 3 characters")
	private String lastName;
	
	@NotNull
	private String email;
	
	private String password;
	
	@Size(min = 10, max = 10, message = "Mobile number should contain 10 digits only")
	private String mobile;
	
	private Long mentorId;
	
	@Column(name = "isContractSent", columnDefinition = "boolean default true")
	private boolean isContractSent = true;
	
	@CreationTimestamp
	private LocalDateTime createdOn = LocalDateTime.now();
	
	@UpdateTimestamp
	private LocalDateTime updateOn = LocalDateTime.now();
	
	@Column(name = "active", columnDefinition = "boolean default true")
	private boolean active = true;
	
	@NotNull
	private String education;
	
	@NotNull
	private String passingYear;
	
	private String mentor;
	
	@Column(name = "isMentorOpted", columnDefinition = "boolean default false")
	private boolean isMentorOpted = false;
	
	private Long incomeId;
	
	@NotNull
	private Long basePackage;
	
	@Column(name = "formalContractRecived", columnDefinition = "boolean default false")
	private boolean formalContractRecived = false;
	
	@Column(name = "formalContractGenerated", columnDefinition = "boolean default false")
	private boolean formalContractGenerated = false;

	@Column(name = "batchCode", columnDefinition = "varchar default false")
	private String batchCode = "SDE13";

}
