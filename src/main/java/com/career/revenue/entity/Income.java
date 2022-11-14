package com.career.revenue.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	private Long amount;
	
	private Long totalFees;
	private Long balanceFees;
	private Long paidFees;
	
	
	private Long incomeCategory;
	private String transactionId;
	private String courierId;
	private String certificationName;

	// audit columns
	@CreationTimestamp
	private LocalDateTime createdOn;
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	private String createdBy;
	private String updatedBy;
	
	@Column(name = "active", columnDefinition = "boolean default true")
	private boolean active = true;

}
