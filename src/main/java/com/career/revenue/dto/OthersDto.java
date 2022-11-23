package com.career.revenue.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OthersDto {

	@CreationTimestamp
	private LocalDateTime createdOn;
	@NotNull
	private Long amount;
	@NotNull
	private String remarks;
	@NotNull
	private Long expenceId;
}
