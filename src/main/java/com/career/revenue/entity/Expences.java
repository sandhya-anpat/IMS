package com.career.revenue.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expences {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expenceId;
	
	@CreationTimestamp
	private LocalDateTime createdOn;
	
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	private String createdBy;
	private String updatedBy;
	
	@Column(name = "active", columnDefinition = "boolean default true")
	private boolean active=true;

}

