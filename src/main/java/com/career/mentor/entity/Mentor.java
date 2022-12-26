package com.career.mentor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
	private Long mentorId;
	
	@NotNull
	private String mentorName;
	
	@NotNull
	private String mentorEmail;
	
	@NotNull
	private String salary;
	
	@Column(name = "batchCode", columnDefinition = "varchar default false")
	private String batchCode = "SDE13";
}
