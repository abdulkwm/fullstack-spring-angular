import { Router } from "@angular/router";
import { EmployeeService } from "../service/employee.service";
import { Employee } from "./../employee";
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{
  employees !: Employee[];
  constructor(private employeeService : EmployeeService, private router : Router){ }
  ngOnInit(): void {
  this.getEmployee();
  }
 getEmployee(){
    this.employeeService.getEmployeeList().subscribe(data => {
      this.employees = data;
    })
  }
  employeeDetails(id : number) {
    this.router.navigate(['employee-details', id]);
  }
  updateEmployee(id : number){
    this.router.navigate(['update-employee', id]);
  }
  deleteEmployee(id : number){
    this.employeeService.deleteEmployee(id).subscribe(data => {
      console.log(data);
      this.employees = this.employees.filter(emp => emp.id !== id);
    })
  }
}
