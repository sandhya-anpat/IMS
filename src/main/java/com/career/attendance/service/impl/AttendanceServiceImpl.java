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

import com.career.attendance.entity.Attendance;
import com.career.attendance.repo.AttendanceRepo;
import com.career.attendance.service.AttendanceService;
import com.career.constants.AppConstants;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	AttendanceRepo attendanceRepo;

	@Autowired
	private ModelMapper mapper;

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
				String mm = sessionDate.substring(2,4);
				String yyyy = sessionDate.substring(4);
				sessionDate = yyyy+"-"+mm+"-"+dd;
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
				attendance.setDate(sessionDate);
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

}
