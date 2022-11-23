package com.career.revenue.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
	
	@NotNull
	private Long studentId;
	
	@NotNull
	private String incomeCategory;
	
	@NotNull
	private Long amount;
	private String certificationName;

}
