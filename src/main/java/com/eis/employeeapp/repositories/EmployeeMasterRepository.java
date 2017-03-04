package com.eis.employeeapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eis.employeeapp.models.EmployeeMaster;

public interface EmployeeMasterRepository extends CrudRepository<EmployeeMaster, Long> {
   
	List<EmployeeMaster> findByLastName(String lastName);
}