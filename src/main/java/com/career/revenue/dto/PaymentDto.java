package com.career.revenue.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.career.constants.CertificationCategory;
import com.career.constants.IncomeCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
	
	@NotNull
	private Long studentId;
	
	@Enumerated(EnumType.STRING)
	private IncomeCategory incomeCategory;
	
	@NotNull
	private Long amount;
	
	@Enumerated(EnumType.STRING)
	private CertificationCategory certificationName;

}
