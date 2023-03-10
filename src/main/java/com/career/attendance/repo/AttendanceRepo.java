package com.career.attendance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.career.attendance.entity.Attendance;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
	
	
}
