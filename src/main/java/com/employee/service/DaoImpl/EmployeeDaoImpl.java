package com.employee.service.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.employee.service.Entity.Employee;
import com.employee.service.Idao.IEmployeeDao;

@Transactional
@Repository
public class EmployeeDaoImpl  implements IEmployeeDao{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Employee> getAll() {
	List<Employee> employeeList = entityManager.createNamedQuery("Employee.getAll",Employee.class).getResultList();
		return employeeList;
	}

	@Override
	public Employee getById(int id) {
		Employee employee = entityManager.createNamedQuery("Employee.getById", Employee.class).setParameter("id", id).getResultList().stream().findFirst().orElse(null);
		return null !=employee ? employee :null;
	}

	@Override
	public void createEmployee(Employee employee) {
		entityManager.persist(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		entityManager.merge(employee);
		
	}

	@Override
	public boolean deleteEmployeeInformation(int id) {
		Query query = entityManager.createQuery("Delete Employee where id =" +id);
		entityManager.flush();
		query.executeUpdate();
		return true;
	}
	
}
