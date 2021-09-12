package com.emp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.emp.model.Employee;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping({ "/employees" })
public class EmployeeCrudController {
	
	static final Logger log = 
	        LoggerFactory.getLogger(EmployeeCrudController.class);
	

	private List<Employee> employees = createList();

	@GetMapping(produces = "application/json")
	public List<Employee> firstPage() {
		try {
			return employees;
		}catch(Exception e) {
		    throw e;
		}
		//return employees;
	}

	@DeleteMapping(path = { "/{id}" })
	public Employee delete(@PathVariable("id") int id) throws Exception {
		try {
			Employee deletedEmp = null;
			for (Employee emp : employees) {
				if (Integer.parseInt(emp.getEmpId())==id) {
					employees.remove(emp);
					deletedEmp = emp;
					break;
				}
			}
			return deletedEmp;
		}catch(Exception e) {
		    throw e;
		}
	}

	@PostMapping("/addEmployee")
	public Employee create(@RequestBody Employee user) throws Exception{
		try {
			employees.add(user);
			return user;
		}catch(Exception e) {
		    throw e;
		}
	}
	
	@PostMapping("/editEmployee")
	public Employee editEmployee(@RequestBody Employee user) throws Exception{
		try {
			for (Employee emp : employees) {
				if (emp.getEmpId().equals(user.getEmpId())) {
					emp.setName(user.getName());
					emp.setDesignation(user.getDesignation());
					emp.setEmpId(user.getEmpId());
					emp.setSalary(user.getSalary());
					emp.setEmployeeType(user.getEmployeeType());
					emp.setDob(user.getDob());
					emp.setJoiningDate(user.getJoiningDate());
				}
			}
			return user;
		}catch(Exception e) {
		    throw e;
		}
	}

	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<>();
		/*Employee emp1 = new Employee();
		emp1.setName("Achin");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(3000);
		emp1.setEmployeeType("Permanent");
		emp1.setDob(new Date());
		emp1.setJoiningDate(new Date());

		Employee emp2 = new Employee();
		emp2.setName("Akriti");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
		emp2.setSalary(3000);
		emp2.setEmployeeType("Temporary");
		emp2.setDob(new Date());
		emp2.setJoiningDate(new Date());
		
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);*/
		return tempEmployees;
	}

}