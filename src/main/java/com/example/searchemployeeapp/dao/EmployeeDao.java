package com.example.searchemployeeapp.dao;

import java.util.List;

import com.example.searchemployeeapp.model.Employee;

public interface EmployeeDao {
    Employee insertEmployee(Employee employee);

    List<Employee> selectAllEmployees();

    Employee selectEmployeeById(String id);

    List<Employee> selectEmployeesByInfo(String name, String joinedDate, String callNumber);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(String id);
}
