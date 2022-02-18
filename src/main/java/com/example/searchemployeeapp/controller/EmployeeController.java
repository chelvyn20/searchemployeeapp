package com.example.searchemployeeapp.controller;

import com.example.searchemployeeapp.model.Employee;
import com.example.searchemployeeapp.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    /*
     * GET Handler to open Add new employee Form
     */
    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model) {
        // create employee object to hold employee form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    /*
     * POST Handler to add new employee
     */
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        // String dateStr = formatter.format(employee.getJoinedDate());
        // System.out.println(dateStr);
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    /*
     * GET Handler to get all employees
     */
    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }

    /*
     * Handler to search employees
     */

    /*
     * GET Handler to open Edit an employee Form
     */
    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable String id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit_employee";
    }

    /*
     * POST Handler to edit an employee
     */
    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable String id,
            @ModelAttribute("employee") Employee employee,
            Model model) {

        // get employee from database by id
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setId(id);
        existingEmployee.setName(employee.getName());
        existingEmployee.setJoinedDate(employee.getJoinedDate());
        existingEmployee.setCallNumber(employee.getCallNumber());
        existingEmployee.setLimitReimburs(employee.getLimitReimburs());

        // save editted employee object
        employeeService.editEmployee(existingEmployee);
        return "redirect:/employees";
    }

    /*
     * Handler to remove an employee
     */
    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable String id) {
        employeeService.removeEmployeeById(id);
        return "redirect:/employees";
    }

}
