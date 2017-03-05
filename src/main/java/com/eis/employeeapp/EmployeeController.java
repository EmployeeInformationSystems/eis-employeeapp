package com.eis.employeeapp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eis.employeeapp.models.EmployeeMaster;
import com.eis.employeeapp.repositories.EmployeeMasterRepository;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeMasterRepository employeeMasterRepository;

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@RequestMapping(method = RequestMethod.POST, value = "/createEmployee")
	@ResponseBody
	public EmployeeMaster createEmployee(@RequestBody EmployeeMaster employeeMaster) {
		try {
			employeeMasterRepository.save(employeeMaster);
			return employeeMaster;
		}
		catch (Exception ex) {
			log.error("something went wrong::"+ex);
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/getEmployeeByLastName/{lastName}")
	@ResponseBody
	public List<EmployeeMaster> getEmployee(@PathVariable("lastName") String lastName){
		List<EmployeeMaster> employees= employeeMasterRepository.findByLastName(lastName);
		System.out.println("size::"+employees.size());
		return employees;
	}
}
