package com.career.mentor.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mentor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@GenericGenerator(name = "mentorId", strategy = "com.career.mentor.generator.MentorGenerator")
	@GeneratedValue(generator = "mentorId")
	private String mentorId;
	
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
	private String email;
	
	@NotNull
	private String salary;
	
	@NotNull
	private String password;
	
	private String tempPassword;
	
	@Column(name = "batchCode", columnDefinition = "varchar default false")
	private String batchCode = "SDE13";
}
