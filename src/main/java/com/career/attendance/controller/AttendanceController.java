package com.career.attendance.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.career.attendance.entity.Attendance;
import com.career.attendance.service.AttendanceService;
import com.career.constants.AppConstants;
import com.career.dto.ResponseDto;
import com.career.exceptions.StudentNotFoundException;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseDto> uploadFile(@RequestParam("file") MultipartFile file) throws FileUploadException {
		if (AppConstants.ATTENDANCE_UPLOAD_FAILURE.equals(attendanceService.uploadfile(file))) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.ATTENDANCE_UPLOAD_FAILURE,
					HttpStatus.BAD_REQUEST.value(), LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.ATTENDANCE_UPLOAD_SUCCESS,
					HttpStatus.OK.value(), LocalDateTime.now().toString()), HttpStatus.OK);
		}
	}
	
	@GetMapping("/getallattendance")
	public ResponseEntity<List<Attendance>> getAllAttendance(){
		return new ResponseEntity<List<Attendance>>(attendanceService.getAllAttendance(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Attendance> findStudentByStudentId(@PathVariable Long id) throws StudentNotFoundException{
		return new ResponseEntity<Attendance>(attendanceService.findStudentByStudentId(id), HttpStatus.OK);
	}
	
	

}
