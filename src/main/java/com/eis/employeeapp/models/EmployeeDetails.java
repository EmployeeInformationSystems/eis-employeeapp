package com.eis.employeeapp.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="eis_employee_details")
public class EmployeeDetails {
	
	@Id
	@NotNull
	@Column(name="emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empid;
	
	@Column(name="date_of_birth")
	@NotNull
	private String dateOfBirth;
	
	@Column(name="ssn")
	@NotNull
	private int ssn;
	
	@Column(name="role")
	@NotNull
	private String role;
	
	@Column(name="dateOfJoining")
	private String dateOfJoining;
	
	@Column(name="terminationDate")
	private String terminationDate;
		
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
	private EmployeeMaster employeeMaster;
	
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(String terminationDate) {
		this.terminationDate = terminationDate;
	}
}
