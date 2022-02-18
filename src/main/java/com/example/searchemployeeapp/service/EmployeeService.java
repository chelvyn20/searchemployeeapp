package com.example.searchemployeeapp.service;

import java.util.List;

import com.example.searchemployeeapp.model.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    List<Employee> searchEmployees(String name, String joinedDate, String callNumber);

    Employee editEmployee(Employee employee);

    void removeEmployeeById(String id);
}
