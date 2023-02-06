package com.career.mentor.entity;

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
	
	@GenericGenerator(name = "mentorId", strategy = "com.career.student.generator")
	@GeneratedValue(generator = "mentorId")
	private String mentorId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String salary;
	
	@NotNull
	private String password;
	
	@Column(name = "batchCode", columnDefinition = "varchar default false")
	private String batchCode = "SDE13";
}
