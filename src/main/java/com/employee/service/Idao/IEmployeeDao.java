package com.employee.service.Idao;

import java.util.List;

import com.employee.service.Entity.Employee;

public interface IEmployeeDao {
	
	List<Employee> getAll();
	
	Employee getById(int id);
	
	void createEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	public boolean deleteEmployeeInformation(int id);

}
