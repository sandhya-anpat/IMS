package com.career.attendance.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.career.attendance.entity.Attendance;
import com.career.attendance.repo.AttendanceRepo;
import com.career.attendance.service.AttendanceService;
import com.career.constants.AppConstants;
import com.career.dto.ResponseDto;
import com.career.exceptions.StudentNotFoundException;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	AttendanceRepo attendanceRepo;

	@Override
	public String uploadfile(InputStream inputStream, String filename) throws FileUploadException {
		String response = AppConstants.ATTENDANCE_UPLOAD_FAILURE;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			String line;
			Attendance attendance = null;
			String sessionName = "";
			String sessionDate = "";
			if (filename != null) {
				sessionName = filename.substring(0, filename.indexOf("_"));
				sessionDate = filename.substring(filename.indexOf("_") + 1, filename.indexOf("."));
				String dd = sessionDate.substring(0, 2);
				String mm = sessionDate.substring(2, 4);
				String yyyy = sessionDate.substring(4);
				sessionDate = yyyy + "-" + mm + "-" + dd;
			}
			List<Attendance> attendances = new ArrayList<Attendance>();
			int count = 0;
			while ((line = reader.readLine()) != null) {
				if (++count == 1)
					continue;
				attendance = new Attendance();
				String[] data = line.split("\\,", -1);
				attendance.setName(data[0].trim());
				attendance.setJoiningTime(data[2].trim());
				attendance.setLeavingTime(data[3].trim());
				attendance.setDuration(data[4].trim());
				attendance.setFileName(filename);
				attendance.setSessionName(sessionName);
				attendance.setSessionDate(getLocalDate(sessionDate));
				attendances.add(attendance);
			}
			attendanceRepo.saveAllAndFlush(attendances);
			response = AppConstants.ATTENDANCE_UPLOAD_SUCCESS;
		} catch (IOException e) {
			throw new FileUploadException();
		}
		return response;
	}

	public LocalDate getLocalDate(String date) {
		if (date == null)
			return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate;
	}

	@Override
	public List<Attendance> getAllAttendance() {
		// TODO Auto-generated method stub
		return attendanceRepo.findAll();
	}

	@Override
	public Attendance findStudentByStudentId(Long id) throws StudentNotFoundException {
		if (!attendanceRepo.existsById(id)) {
			throw new StudentNotFoundException();
		}
		return attendanceRepo.findById(id).get();
	}

	@Override
	public List<Attendance> getAttendanceByDateAndSessionName(String startDate, String endDate, String sessionName) {
		// TODO Auto-generated method stub

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		if (startDate == null && endDate == null && sessionName == null) {
			return attendanceRepo.findAll();
		} else if (startDate != null && endDate != null) {

			LocalDate start = LocalDate.parse(startDate, formatter);
			LocalDate end = LocalDate.parse(endDate, formatter);
			return attendanceRepo.findAttendanceByStartDateAndEndDate(start, end);
		}

		else {
			return attendanceRepo.findBySessionName(sessionName);
		}

		// return AppConstants.INVALID_DATE;
	}

}
