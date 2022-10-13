package com.employee.service.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name ="Employee")

@NamedQueries({
	@NamedQuery(name ="Employee.getAll",
			    query= "SELECT em FROM Employee em"),
	@NamedQuery(name ="Employee.getById",
			   query= "SELECT em FROM Employee em WHERE em.id =:id" )
})
public class Employee  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", nullable = true)
	private int employeeId;
	
	@Column(name="EMPLOYEE_NAME", nullable = true)
	private String employeeName;
	
	@Column(name="DATE_OF_BIRTH", nullable = true)
	private Date dateOfBirth;
	
	@Column(name="DATE_OF_JOIN", nullable = true)
	private Date dateOfJoin;
	
	@Column(name="DEPARTMENT", nullable = true)
	private String department;
	
	@Column(name="PHOTOS", nullable = true)
	private String photos;
	
	@Column(name="IS_ACTIVE", nullable = true)
	private boolean isActive;
	
	@Column(name="IS_DELETED", nullable = true)
	private boolean isDeleted;
	
	@Column(name="CREATED_ON", nullable = true)
	private Date createdOn;
	
	
	
	
	public Employee() {
		super();
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the dateOfJoin
	 */
	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	/**
	 * @param dateOfJoin the dateOfJoin to set
	 */
	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the photos
	 */
	public String getPhotos() {
		return photos;
	}

	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(String photos) {
		this.photos = photos;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	

}
