package com.career;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.career.mentor.entity.Mentor;
import com.career.mentor.repo.MentorRepo;
import com.career.student.entity.Student;
import com.career.student.repo.StudentRepo;

@SpringBootApplication
public class Ims1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Ims1Application.class, args);

		StudentRepo studentRepo = run.getBean(StudentRepo.class);

		List<Student> studentList = Arrays.asList(
				new Student("John", "Doe", "johndoe@gmail.com", "9988998877", "B.E.", "2020", 500000L),
				new Student("James", "Louise", "foxjames@gmail.com", "8989897676", "M.Sc. IT", "2022", 600000L),
				new Student("Alice", "Williams", "alice@gmail.com", "8899888999", "M.C.A.", "2021", 450000L),
				new Student("Nathan", "Humphires", "nathan@gmail.com", "9987778877", "B.E.", "2022", 745000L),
				new Student("Lavell", "Scott", "lios@gmail.com", "8080808080", "B.E.", "2021", 625000L));

		studentRepo.saveAll(studentList);
		studentRepo.flush();
		
		MentorRepo  mentorRepo = run.getBean(MentorRepo.class);
		
		List<Mentor> mentorList = Arrays.asList(
				new Mentor(1L,"Vaibhav","500000","SDE13",true),
				new Mentor(2L,"Rahul","500000","SDE14",true));
		
		mentorRepo.saveAll(mentorList);
		mentorRepo.flush();
	}

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
