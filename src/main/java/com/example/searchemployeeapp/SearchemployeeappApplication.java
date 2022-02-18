package com.example.searchemployeeapp;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.searchemployeeapp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchemployeeappApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SearchemployeeappApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Employee emp1 = new Employee("Chelvyn1", "28-FEB-2022", "0895800142380", new
		// BigDecimal("10000000.00"));
		// Employee emp2 = new Employee("Chelvyn1", "29-FEB-2022", "0895800242380", new
		// BigDecimal("10000000.00"));
		// Employee emp3 = new Employee("Chelvyn1", "30-FEB-2022", "0895800342380", new
		// BigDecimal("10000000.00"));
		// Employee emp4 = new Employee("Chelvyn1", "30-FEB-2022", "0895800342381", new
		// BigDecimal("10000000.00"));
		// Employee emp5 = new Employee("Chelvyn1", "30-FEB-2022", "0895800342382", new
		// BigDecimal("10000000.00"));

		// employeeService.addEmployee(emp1);
		// employeeService.addEmployee(emp2);
		// employeeService.addEmployee(emp3);
		// employeeService.addEmployee(emp4);
		// employeeService.addEmployee(emp5);

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		String str = formatter.format(date);
		System.out.println("Date: " + date);
		System.out.println("Str: " + str);

		// List<Employee> employees = employeeService.searchEmployees(null, null, null);
		// System.out.println(employees + "\n");

		// Employee emp = employeeService.getEmployeeById("k-001");
		// System.out.println("Emp:" + emp);
		// // employeeService.editEmployeeById("k-001", "Chelvyn10", "", null);
	}

}
