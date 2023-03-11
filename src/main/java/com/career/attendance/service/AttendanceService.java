package com.career.attendance.service;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.career.attendance.entity.Attendance;

@Service
public interface AttendanceService {

	String uploadfile(MultipartFile file) throws FileUploadException;

	List<Attendance> getAllAttendance();

	 

	
}
