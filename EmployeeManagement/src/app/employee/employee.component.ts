import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { HttpClientService, Employee } from "../service/httpclient.service";

@Component({
  selector: "app-employee",
  templateUrl: "./employee.component.html",
  styleUrls: ["./employee.component.css"]
})
export class EmployeeComponent implements OnInit {
  employees: Employee[];
  displayedColumns: string[] = ["empId","name","dob","joiningDate","designation","salary","terminationDate","delete"];

  constructor(private httpClientService: HttpClientService, private route:Router) {}

  ngOnInit() {
    this.httpClientService
      .getEmployees()
      .subscribe(response => this.handleSuccessfulResponse(response));
  }
  editEmployee(employee: Employee): void {
    this.httpClientService.currentEmployee=employee;
    this.route.navigate(['/editemployee', employee.empId]);
  }

  handleSuccessfulResponse(response) {
    this.employees = response;
  }

  deleteEmployee(employee: Employee): void {
    this.httpClientService.deleteEmployee(employee).subscribe(data => {
      this.httpClientService
      .getEmployees()
      .subscribe(response => this.handleSuccessfulResponse(response));
    });
  }
}
