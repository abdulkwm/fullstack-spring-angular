package com.app;

import com.app.entity.Employee;
import com.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeBackEndApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeBackEndApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Abdu");
		employee.setLastName("Mohammed");
		employee.setEmailId("abdu@gmail.com");
		employeeRepository.save(employee);
	}
}
