package com.employee.service.IService;

import java.util.List;

import com.employee.service.Entity.Employee;

public interface IEmployeeService {
	
	List<Employee> getAll();
	Employee getById(int id);
	
	public boolean createEmployee(Employee employee);
	
	public boolean updateEmployee(Employee employee);
	
	public boolean deleteEmployeeInformation(int id);

}
