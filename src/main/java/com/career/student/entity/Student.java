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
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

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
	
	@Column(name = "studentId")
	private String studentId;
	
	@NotNull
	@Size(min = 3, message = "Firstname should contain atleast 3 characters")
	private String firstName;
		
	
	@NotNull
	@Size(min = 3, message = "Lastname should contain atleast 3 characters")
	private String lastName;
	


	
	private String password;
	
	private String tempPassword;
	
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
	private String gender;
	
	@NotNull
	private String address;
	
	@NotNull
	private LocalDateTime dob;
	
	@NotNull
	private String course;
	
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

	private @NotNull String email;

	// For registration through main() method
	public Student(@NotNull @Size(min = 3, message = "Firstname should contain atleast 3 characters") String firstName,
			@NotNull @Size(min = 3, message = "Lastname should contain atleast 3 characters") String lastName,
			String studentId,
			@NotNull String email,
			@Size(min = 10, max = 10, message = "Mobile number should contain 10 digits only") String mobile,
			@NotNull String education, @NotNull String passingYear, @NotNull Long basePackage) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
		this.email = email;
		this.mobile = mobile;
		this.education = education;
		this.passingYear = passingYear;
		this.basePackage = basePackage;
	}

	
}
