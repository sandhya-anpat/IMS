package com.career.attendance.service;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.career.attendance.entity.Attendance;
import com.career.dto.ResponseDto;

@Service
public interface AttendanceService {

	String uploadfile(InputStream inputStream, String filename) throws FileUploadException;

	List<Attendance> getAllAttendance();

	Attendance findStudentByStudentId(Long id);

	List<Attendance> getAttendanceByDateAndSessionName(String startDate,String endDate, String sessionName);

	 

	
}
