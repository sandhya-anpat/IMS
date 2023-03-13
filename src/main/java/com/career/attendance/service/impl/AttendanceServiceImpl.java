package com.career.attendance.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.career.attendance.entity.Attendance;
import com.career.attendance.repo.AttendanceRepo;
import com.career.attendance.service.AttendanceService;
import com.career.constants.AppConstants;
import com.career.exceptions.StudentNotFoundException;
import com.career.mentor.repo.MentorRepo;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	AttendanceRepo attendanceRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public String uploadfile(MultipartFile file) throws FileUploadException {
		String response = AppConstants.ATTENDANCE_UPLOAD_FAILURE;
		InputStream inputStream;
		try {
			inputStream = file.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			String line;
			Attendance attendance = null;
			List<Attendance> attendances = new ArrayList<Attendance>();
			while ((line = reader.readLine()) != null) {
				attendance = new Attendance();
				String[] data = line.split("\\,", -1);
				attendance.setName(data[0].trim());
				attendance.setJoiningTime(data[2].trim());
				attendance.setLeavingTime(data[3].trim());
				attendance.setDuration(data[4].trim());
				attendance.setFileName(file.getOriginalFilename());
				attendances.add(attendance);
			}
			attendanceRepo.saveAllAndFlush(attendances);
			response = AppConstants.ATTENDANCE_UPLOAD_SUCCESS;
		} catch (IOException e) {
			throw new FileUploadException();
		}
		return response;
	}

	@Override
	public List<Attendance> getAllAttendance() {
		// TODO Auto-generated method stub
		return attendanceRepo.findAll();
	}

	@Override
	public Attendance findStudentByStudentId(Long id) throws StudentNotFoundException {
		if(!attendanceRepo.existsById(id)) {
			throw new StudentNotFoundException(); 
		}
		return attendanceRepo.findById(id).get(); 
	}

}
