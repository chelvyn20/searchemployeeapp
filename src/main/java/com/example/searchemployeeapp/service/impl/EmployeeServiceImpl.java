package com.example.searchemployeeapp.service.impl;

import java.util.List;

import com.example.searchemployeeapp.dao.EmployeeDao;
import com.example.searchemployeeapp.model.Employee;
import com.example.searchemployeeapp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.selectAllEmployees();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeDao.selectEmployeeById(id);
    }

    @Override
    public List<Employee> searchEmployees(String name, String joinedDate, String callNumber) {
        return employeeDao.selectEmployeesByInfo(name, joinedDate, callNumber);
    }

    @Override
    public Employee editEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public void removeEmployeeById(String id) {
        employeeDao.deleteEmployeeById(id);
    }

}
