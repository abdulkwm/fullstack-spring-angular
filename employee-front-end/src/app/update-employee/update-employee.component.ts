import { Employee } from "./../employee";
import { EmployeeService } from "./../service/employee.service";
import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit{
  id !: number;
  employee !: Employee;
  constructor(private employeeService : EmployeeService, private route : ActivatedRoute, private router : Router) {
  }
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.employee = new Employee();
    this.employeeService.getEmployeeById(this.id).subscribe(data => {
      this.employee = data;
    }, error => console.log(error)
    );
  }
  goToEmployeeList() {
    // if (this.employee.firstName.length > 0 && this.employee.lastName.length > 0 && this.employee.emailId.length > 0) {
      this.router.navigate(['/employees']);
    // } else {
    //   console.log("the data is empty")
    // }
  }
onSubmit(){
  this.employeeService.updateEmployee(this.id, this.employee).subscribe(data => {
    this.goToEmployeeList();
  });
}
}
