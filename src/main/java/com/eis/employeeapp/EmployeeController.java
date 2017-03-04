package com.eis.employeeapp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eis.employeeapp.models.EmployeeDetails;
import com.eis.employeeapp.models.EmployeeMaster;
import com.eis.employeeapp.repositories.EmployeeMasterRepository;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeMasterRepository employeeMasterRepository;

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping("/createEmployee")
	@ResponseBody
	public void createEmployee() {
		System.out.println("inside create employee");
		try {
			EmployeeMaster emp=new EmployeeMaster();
			emp.setFirstName("bharath");
			emp.setLastName("Kollareddy");
			emp.setCreatedBy("employeeapp");
			SimpleDateFormat format= new SimpleDateFormat("MMddyyyy");
			emp.setCreatedDate(format.format(new Date()));
			
			EmployeeDetails employeeDetails= new EmployeeDetails();
			employeeDetails.setDateOfBirth(format.format(new Date()));
			employeeDetails.setSsn(123);
			
			emp.setEmployeeDetails(employeeDetails);
			
			employeeMasterRepository.save(emp);
			log.info("Record created::"+emp.getEmpid());
		}
		catch (Exception ex) {
			log.error("something went wrong::"+ex);
		}
	}
}
