package com.career.revenue.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.career.revenue.entity.Income;

@Repository
public interface IncomeRepo extends JpaRepository<Income, Long> {
	
	
	
}
