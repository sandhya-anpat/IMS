package com.career.student.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private Long mentorId;
	private boolean isContractSent = true;
	private LocalDateTime createdOn = LocalDateTime.now();
	private LocalDateTime updateOn = LocalDateTime.now();
	private boolean active = true;
	private String education;
	private String passingYear;
	private String mentor;
	private boolean isMentorOpted = false;
	private Long incomeId;
	private Long basePackage;
	private boolean formalContractRecived = false;
	private boolean formalContractGenerated = false;
	private String batchCode = "SDE13";

}
