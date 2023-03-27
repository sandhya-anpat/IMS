package com.career.attendance.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.career.attendance.entity.Attendance;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
	
	
	List<Attendance> findBySessionNameAndSessionDateBetween(String sessionName, LocalDate startDate, LocalDate endDate);
	
	@Query("SELECT a FROM Attendance a WHERE a.sessionDate BETWEEN :startDate AND :endDate")
	List<Attendance> findAttendanceByStartDateAndEndDate(LocalDate startDate, LocalDate endDate);
	
	List<Attendance> findBySessionName(String sessionName);
}
