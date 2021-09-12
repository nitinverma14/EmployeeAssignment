import { Component, OnInit } from "@angular/core";
import { HttpClientService, Employee } from "../service/httpclient.service";
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: "app-add-employee",
  templateUrl: "./add-employee.component.html",
  styleUrls: ["./add-employee.component.css"]
})
export class AddEmployeeComponent implements OnInit {
  user: Employee = new Employee("", "", "", null,null,"","",null);
  submitted = false;
  id:any;
  buttonText='Save';
  onSubmit() { this.submitted = true; 
  if(this.submitted){
    if(this.id){
      this.editEmployee();
    }else{
      this.createEmployee();
    }
  }
  }

  constructor(private httpClientService: HttpClientService,
    private router: Router,private activatedRoute:ActivatedRoute) {}

    numberOnly(event): boolean {
      const charCode = (event.which) ? event.which : event.keyCode;
      if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
      }
      return true;
  
    }
  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id'];
      this.setDataToEdit();
      });

  }
 setDataToEdit():void{
   if(this.id){
   this.buttonText='Update';}else {this.buttonText='Save';}
  if(this.httpClientService.currentEmployee && this.httpClientService.currentEmployee.empId== this.id){
    this.user=this.httpClientService.currentEmployee ;
    if(this.httpClientService.currentEmployee.dob){
    this.user.dob=new Date(this.httpClientService.currentEmployee.dob);
   }
   if(this.httpClientService.currentEmployee.joiningDate){
    this.user.joiningDate=new Date(this.httpClientService.currentEmployee.joiningDate);
   }
   if(this.httpClientService.currentEmployee.terminationDate){
    this.user.terminationDate=new Date(this.httpClientService.currentEmployee.terminationDate);
   }
  }

}

getEditable(){
  if(this.id){return true;}else return false;
}
  createEmployee(): void {
    console.debug(this.user);
    this.httpClientService.createEmployee(this.user).subscribe(data => {
      alert("Employee created successfully.");
      this.router.navigate([''])
    });
  }
  editEmployee(): void {
    console.debug(this.user);
    this.httpClientService.editEmployee(this.user).subscribe(data => {
      alert("Employee updated successfully.");
      this.router.navigate([''])
    });
  }
}
