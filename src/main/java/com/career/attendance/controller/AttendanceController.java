package com.career.attendance.controller;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.career.attendance.entity.Attendance;
import com.career.attendance.service.AttendanceService;
import com.career.constants.AppConstants;
import com.career.dto.ResponseDto;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseDto> uploadFile(InputStream inputStream, @RequestParam("filename") String filename) throws FileUploadException {
		if (AppConstants.ATTENDANCE_UPLOAD_FAILURE.equals(attendanceService.uploadfile(inputStream, filename))) {
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

}
