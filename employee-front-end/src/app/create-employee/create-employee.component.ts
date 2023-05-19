import { EmployeeService } from "./../service/employee.service";
import { Employee } from "./../employee";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit{
  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService, private router: Router) {
  }
  ngOnInit(): void {
    
  }
  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(data => {
      console.log(data);
      this.goToEmployeeList();
    });
  }
  goToEmployeeList(){
    if(this.employee.firstName.length > 0 && this.employee.lastName.length > 0 && this.employee.emailId.length > 0){
      this.router.navigate(['/employees']);
    }else{
      console.log("the data is empty")
    }
  }
  onSubmit() {
    if (this.employee.firstName.length > 0 && this.employee.lastName.length > 0 && this.employee.emailId.length > 0) {
      this.saveEmployee();
    }else{
      console.log("the data is empty");
    }
      console.log(this.employee);
  }
}
