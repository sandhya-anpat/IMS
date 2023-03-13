package com.career;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.career.student.entity.Student;
import com.career.student.repo.StudentRepo;

@SpringBootApplication
public class Ims1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Ims1Application.class, args);

		StudentRepo studentRepo = run.getBean(StudentRepo.class);

		List<Student> studentList = Arrays.asList(
				new Student("Prachi", "Desai", "CI0001", "prachi@gmail.com", "9988998877", "B.E.", "2020", 500000L),
				new Student("Vishakha", "Deshmukh", "CI0002", "vishakha@gmail.com", "8989897676", "M.Sc. IT", "2022",
						600000L),
				new Student("Sandhya", "Anpat", "CI0003", "sandhya@gmail.com", "8899888999", "M.C.A.", "2021", 450000L),
				new Student("Abhishekh", "Bodkhe", "CI0003", "abhi@gmail.com", "9987778877", "B.E.", "2022", 745000L),
				new Student("Sonali", "Patil", "CI0005", "lios@gmail.com", "8080808080", "B.E.", "2021", 625000L),

				new Student("Aman", "Naik", "CI0006", "aman@gmail.com", "9988995654", "B.E.", "2020", 500000L),
				new Student("Ganesh", "Shirke", "CI0007", "ganesh@gmail.com", "9090897676", "M.Sc. IT", "2022",
						600000L),
				new Student("Raj", "Dharmadhikari", "CI0008", "raj@gmail.com", "8899544344", "M.C.A.", "2021", 450000L),
				new Student("Harsha", "Saini", "CI0009", "harsha@gmail.com", "9000755877", "B.E.", "2022", 745000L),
				new Student("Bhushan", "Chaudhari", "CI0010", "bhushan@gmail.com", "8087878786", "B.E.", "2021",
						625000L));

		studentRepo.saveAll(studentList);
		studentRepo.flush();
	}

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

	@SuppressWarnings("deprecation")
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}
