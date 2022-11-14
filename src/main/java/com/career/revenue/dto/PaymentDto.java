package com.career.revenue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
	
	private Long studentId;
	private String incomeCategory;
	private Long amount;
	private String certificationName;

}
