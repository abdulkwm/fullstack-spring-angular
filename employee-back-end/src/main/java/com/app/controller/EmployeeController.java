package com.app.controller;

import com.app.entity.Employee;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin ("*")
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee createdEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeService.getEmployeeById(id);
//        we can also do in two ways
//        return ResponseEntity.ok(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    //it is another way to show both the msg and the updated object to postman;
//    @PutMapping("/{id}")
//    public ResponseEntity<Map<String,Object>> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
//        Employee updatedEmployee = employeeService.updateEmployee(id,employeeDetails);
//        String msg = "Employee with the id " + id + " is updated!";
//        Map<String, Object> response = new HashMap<>();
//        response.put("employee",updatedEmployee);
//        response.put("message",msg);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetails){
        Employee updatedEmployee = employeeService.updateEmployee(id,employeeDetails);
        String msg = "Employee With the Id " + id + " is Updated!";
        return updatedEmployee;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        Employee employee = employeeService.deleteEmployee(id);
        String msg = "Employee with id " + employee.getId() + " is Deleted";
        return ResponseEntity.ok(msg);
    }
}
