package com.employee.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.service.Entity.Employee;
import com.employee.service.IService.IEmployeeService;
import com.employee.service.Idao.IEmployeeDao;

@Service
public class EmployeeServiceImpl  implements IEmployeeService{
	
	@Autowired
	IEmployeeDao employeeDao;

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public Employee getById(int id) {
		return employeeDao.getById(id);
	}

	@Override
	public boolean createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
		return true;
	}

	@Override
	public boolean deleteEmployeeInformation(int id) {
		employeeDao.deleteEmployeeInformation(id);
		return true;
	}

}
