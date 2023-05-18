package com.app.service;

import com.app.entity.Employee;

import java.util.List;

public interface EmployeeService {
Employee addEmployee(Employee employee);
List<Employee> getAllEmployees();
Employee getEmployeeById(long id);
Employee updateEmployee(long id, Employee employeeDetails);
Employee deleteEmployee(long id);
}
