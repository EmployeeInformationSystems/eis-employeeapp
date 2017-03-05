package com.eis.employeeapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eis.employeeapp.models.Address;
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
	public EmployeeMaster createEmployee() {
		try {
			EmployeeMaster employeeMaster=new EmployeeMaster();
			employeeMaster.setFirstName("bharath");
			employeeMaster.setLastName("Kollareddy");
			employeeMaster.setCreatedBy("employeeapp");
			SimpleDateFormat format= new SimpleDateFormat("MMddyyyy");
			employeeMaster.setCreatedDate(format.format(new Date()));
			
			EmployeeDetails employeeDetails= new EmployeeDetails();
			employeeDetails.setDateOfBirth(format.format(new Date()));
			employeeDetails.setSsn(123);
			employeeDetails.setRole("Employee");
			employeeDetails.setDateOfJoining(format.format(new Date()));
			employeeMaster.setEmployeeDetails(employeeDetails);
			
			Address address= new Address();
			address.setAddressLine1("1100 west chester pike");
			address.setAddressLine2("apt j07");
			address.setCity("west chester");
			address.setState("PA");
			address.setCountry("usa");
			employeeMaster.setAddress(address);
			
			employeeMasterRepository.save(employeeMaster);
			log.info("Record created::"+employeeMaster.getEmpid());
			return employeeMaster;
		}
		catch (Exception ex) {
			log.error("something went wrong::"+ex);
			return null;
		}
	}
	
	@RequestMapping("/getEmployeeByLastName/{lastName}")
	@ResponseBody
	public List<EmployeeMaster> getEmployee(@PathVariable("lastName") String lastName){
		List<EmployeeMaster> employees= employeeMasterRepository.findByLastName(lastName);
		System.out.println("size::"+employees.size());
		return employees;
	}
}
