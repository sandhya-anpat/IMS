package com.career.attendance.controller;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

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

import okhttp3.ResponseBody;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseDto> uploadFile(@RequestParam("filename") MultipartFile file)
			throws IOException {
		
		String filename=file.getName();
		if(null != filename && validateFileName(filename)) {
		if (AppConstants.ATTENDANCE_UPLOAD_FAILURE.equals(attendanceService.uploadfile(file.getInputStream(), file.getOriginalFilename()))) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.ATTENDANCE_UPLOAD_FAILURE,
					HttpStatus.BAD_REQUEST.value(), LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.ATTENDANCE_UPLOAD_SUCCESS,
					HttpStatus.OK.value(), LocalDateTime.now().toString()), HttpStatus.OK);
		}
		}else {
			return new ResponseEntity<ResponseDto>(new ResponseDto(AppConstants.INVALID_FILE_NAME,
					HttpStatus.OK.value(), LocalDateTime.now().toString()), HttpStatus.OK);
		}
	}

	@GetMapping("/getAllAttendance")
	public ResponseEntity<List<Attendance>> getAllAttendance() {
		return new ResponseEntity<List<Attendance>>(attendanceService.getAllAttendance(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Attendance> findStudentByStudentId(@PathVariable Long id) throws StudentNotFoundException {
		return new ResponseEntity<Attendance>(attendanceService.findStudentByStudentId(id), HttpStatus.OK);
	}

	@PostMapping("/getAttendanceByDateAndSesssionName")
	public ResponseEntity<List<Attendance>> getAttendanceByDateAndSessionName(@RequestParam(name = "start", required = false) String startDate,
			@RequestParam(name = "end", required = false) String endDate, @RequestParam(name = "session", required = false) String sessionName) {

	
//		 attendanceService.getAttendanceByDateAndSessionName(startDate,endDate,sessionName);

		return new ResponseEntity<List<Attendance>>(
				attendanceService.getAttendanceByDateAndSessionName(startDate, endDate, sessionName), HttpStatus.OK);
	}
	
	public static boolean validateFileName(String filename) {
		boolean isValid = false;
		String sessionName="";
		String sessionDate="";
		try {
		if(!filename.contains("_")) {
			return false;
		}else {
			sessionName=filename.substring(0, filename.indexOf("_"));
			sessionDate=filename.substring(filename.indexOf("_")+1, filename.indexOf("."));
		
			if(AppConstants.VALID_FILE_NAME.contains(sessionName) && sessionDate.length()==8) {
				isValid=true;
			}
		}
		}catch(Exception ex) {
			isValid=false;
			ex.printStackTrace();
		}
		return isValid;
	}

}
