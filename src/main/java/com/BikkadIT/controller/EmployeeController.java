package com.BikkadIT.controller;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Employee;
import com.BikkadIT.service.ServiceI;

@RestController
public class EmployeeController {
	@Autowired
	private ServiceI serviceI;

	@PostMapping(value="/addEmployee" , produces="application/json")
	public ResponseEntity<Integer> addEmployee(@RequestBody Employee Employee) {
		int addEmployee = serviceI.addEmployee(Employee);
		return new ResponseEntity<Integer>(addEmployee, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllEmployee", consumes="application/json",produces="application/json")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> list = serviceI.getAllEmployee();
		System.out.println(list);
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);

	}

	@GetMapping(value = "/getById/{empId}",consumes="application/json",produces="application/json")
	public ResponseEntity<Employee> getById(@PathVariable int empId) {
		Employee id = serviceI.getById(empId);
		if (id != null) {
			return new ResponseEntity<Employee>(id, HttpStatus.OK);

		} else {
			return new ResponseEntity<Employee>(id, HttpStatus.BAD_REQUEST);
		}

	}
   
	
	@PostMapping(value="/updateEmployee", produces="application/json")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		int updateEmployee = serviceI.updateEmployee(employee);

		return new ResponseEntity<String>("Data update Successfully,", HttpStatus.OK);
	}

	@GetMapping(value="/deleteById/{empId}",consumes="application/json",produces="application/json")
	public ResponseEntity<String> deleteById(@PathVariable int empId) {
		serviceI.deleteEmployee(empId);
		return new ResponseEntity<String>("Delete Single Data Successfully.", HttpStatus.OK);

	}

	@GetMapping(value="/deleteAllEmployee",consumes="application/json",produces="application/json")
	public ResponseEntity<String> deleteAllEmployee(Employee Employee) {
		serviceI.deleteAllEmployee(Employee);
		return new ResponseEntity<String>("delete All Employee Successfully.", HttpStatus.OK);
	}
	
	@PostMapping (value="/addMultipleEmployee", produces="application/json")
	public ResponseEntity<List<Employee>> addMultipleEmployee(@RequestBody List < Employee> employee){
		List<Employee> multipleAdding = serviceI.addMultipleEmployee(employee);
		return new ResponseEntity<List<Employee>>(multipleAdding,HttpStatus.OK);
	}
	
     @PostMapping (value="/loginCheck", produces="application/json")
	public ResponseEntity<String> loginCheck(@RequestBody Employee employee){
		Employee loginCheck = serviceI.loginCheck(employee);
		
		if(loginCheck!=null) {
			String smg="login successfully completed.";
			return new ResponseEntity<String>(smg,HttpStatus.OK);
		}
		else {
			String smg1="login fail.";
			return new ResponseEntity<String>(smg1,HttpStatus.NOT_FOUND);
		}
		}
     @GetMapping (value="/getByAge/{empAge}",consumes="application/json",produces="application/json")
     public ResponseEntity<List<Employee>> getByEmpAge(@PathVariable int empAge){
    	 List<Employee> list = serviceI.findByEmpAgeLessThanEqual(empAge);
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
    	 
     }
     
     @PostMapping (value="/updateMultipleEmployee", produces="application/json")
 	public ResponseEntity<String> updateMultipleEmployee(@RequestBody List <Employee> employee){
    	 List<Employee> updateMultipleEmployee = serviceI.updateMultipleEmployee(employee);
		return new ResponseEntity<String>("update mutliple Employee successfully.",HttpStatus.OK);

         
 	}
 	
}

	

