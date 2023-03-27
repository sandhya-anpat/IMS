package com.career.attendance.entity;

import java.time.LocalDate;

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
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;
	
	@NotNull
	private String joiningTime;
	
	@NotNull
	private String leavingTime;
	
	@NotNull
	private String duration;
	
	@NotNull
	private String sessionName;
	                  
	@NotNull
	private LocalDate sessionDate;
	
	@NotNull
	private String fileName;
	
}
