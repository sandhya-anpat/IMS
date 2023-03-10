package com.career.revenue.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.career.constants.Category;
import com.career.revenue.entity.Expences;

@Repository
public interface ExpencesRepo extends JpaRepository<Expences, Long> {
	
  List<Expences> findExpenceByCategory(Category category);

}
