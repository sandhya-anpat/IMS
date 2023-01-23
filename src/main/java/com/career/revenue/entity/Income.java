package com.career.revenue.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.career.constants.CertificationCategory;
import com.career.constants.IncomeCategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long incomeId;
	
	@NotNull
	private Long studentId;
	
	@NotNull(message = "amount cannot be null")
	private Long amount;
	
	@NotNull
	private Long totalFees;
	
	@NotNull
	private Long balanceFees;
	
	@NotNull
	private Long paidFees;
	
	@Enumerated(EnumType.STRING)
	private IncomeCategory incomeCategory;
	
	@NotNull(message = "transaction id cannot be null")
	private String transactionId;
	
	@NotNull(message = "courier id cannot be null")
	private String courierId;
	
	@Enumerated(EnumType.STRING)
	private CertificationCategory certificationName;

	// audit columns
	@CreationTimestamp
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	
	@NotNull
	private String createdBy;
	
	@NotNull
	private String updatedBy;
	
	@Column(name = "active", columnDefinition = "boolean default true")
	private boolean active = true;

}
