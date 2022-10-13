package com.employee.service.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.service.Constrant.ServiceConstant;
import com.employee.service.Entity.Employee;
import com.employee.service.IService.IEmployeeService;
import com.mysql.cj.util.DnsSrv.SrvRecord;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	// 1. Create Employee

	@PostMapping("/create")
	ResponseEntity<Map<String, String>> createEmployee(@RequestBody @Validated Map<String, String> json) {
		Map<String, String> response = new HashMap<String, String>();
		Employee employee = new Employee();
		employee.setActive(Boolean.TRUE);
		employee.setDeleted(Boolean.FALSE);
		employee.setCreatedOn(new Date());
		employee.setDepartment(json.get(ServiceConstant.DEPARTMENT));
		employee.setEmployeeName(json.get(ServiceConstant.EMPLOYEE_NAME));
		if (null != json.get(ServiceConstant.PHOTOS)) {
			employee.setPhotos(json.get(ServiceConstant.PHOTOS));
		}

		try {
			employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(json.get(ServiceConstant.DATE_OF_BIRTH)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			employee.setDateOfJoin(new SimpleDateFormat("yyyy-MM-dd").parse(json.get(ServiceConstant.DATE_OF_JOIN)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean create = employeeService.createEmployee(employee);
		if (create) {
			response.put("Status", Boolean.TRUE.toString());
			response.put("Description", "Successfully created");
		} else {
			response.put("Status", Boolean.FALSE.toString());
			response.put("Description", "Not created with given name");
		}
		return ResponseEntity.ok().body(response);

	}

	// 2. Update Employee

	@PutMapping("/update")
	ResponseEntity<Map<String, String>> updateEmployee(@RequestBody Map<String, String> json) {
		Map<String, String> response = new HashMap<String, String>();
		if (null != json.get(ServiceConstant.ID)
				&& null != employeeService.getById(Integer.parseInt(json.get(ServiceConstant.ID)))) {
			int id = Integer.parseInt(json.get(ServiceConstant.ID));
			Employee employee = employeeService.getById(id);

			if (null != json.get(ServiceConstant.DEPARTMENT)) {
				employee.setDepartment(json.get(ServiceConstant.DEPARTMENT));
			}

			if (null != json.get(ServiceConstant.EMPLOYEE_NAME)) {
				employee.setEmployeeName(json.get(ServiceConstant.EMPLOYEE_NAME));
			}

			if (null != json.get(ServiceConstant.EMPLOYEE_NAME)) {
				employee.setEmployeeName(json.get(ServiceConstant.EMPLOYEE_NAME));
			}

			if (null != json.get(ServiceConstant.DATE_OF_BIRTH)) {
				try {
					employee.setDateOfBirth(
							new SimpleDateFormat("yyyy-MM-dd").parse(json.get(ServiceConstant.DATE_OF_BIRTH)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (null != json.get(ServiceConstant.DATE_OF_JOIN)) {
				try {
					employee.setDateOfJoin(
							new SimpleDateFormat("yyyy-MM-dd").parse(json.get(ServiceConstant.DATE_OF_JOIN)));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			boolean update = employeeService.updateEmployee(employee);
			if (update) {
				response.put("Ststus", Boolean.TRUE.toString());
				response.put("Description", "Your information has updated successfully");
			} else {
				response.put("Ststus", Boolean.FALSE.toString());
				response.put("Description", "Your information has not updated");
			}

		} else {
			response.put("ststus", Boolean.FALSE.toString());
			response.put("Description", "Please enter employeeId");
		}

		return ResponseEntity.ok().body(response);

	}

	// 3. Delete Employee

	@DeleteMapping("/delete/{id}")
	ResponseEntity<Map<String, String>> deleteEmployeeInformation(@PathVariable("id") int id) {
		Map<String, String> response = new HashMap<String, String>();
		Employee employee = employeeService.getById(id);
		if (null != employee) {
			boolean deleteEmployeeInformation = employeeService.deleteEmployeeInformation(id);
			if (deleteEmployeeInformation) {
				response.put("ststus", Boolean.TRUE.toString());
				response.put("Description", "Deleted successfully");
			} else {
				response.put("ststus", Boolean.FALSE.toString());
				response.put("Description", "Employee information has not deleted successfully");
			}
		} else {
			response.put("ststus", Boolean.FALSE.toString());
			response.put("Description", "Please select employeeId");
		}
		return ResponseEntity.ok().body(response);

	}

	// 4. Fetch All Employee

	@GetMapping("getall")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> employeeList = employeeService.getAll();
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);

	}

	// 5. Fetch Employee by Id
	@GetMapping("get/{id}")
	public ResponseEntity<Employee> getById(@PathVariable("id") int id) {
		Employee employee = employeeService.getById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

}
