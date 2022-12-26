package com.career.mentor.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.career.mentor.entity.Mentor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MentorUpdateDto {
	
	
	private Long mentorId;
	
	@NotNull
	private String mentorName;
	
//	@NotNull
//	private String mentorEmail;
	
//	@NotNull
//	private String salary;
	
	@Column(name = "batchCode", columnDefinition = "varchar default false")
	private String batchCode = "SDE13";

}
