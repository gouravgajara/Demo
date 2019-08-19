package com.example.demo.Controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	
	private static final Logger LOG = Logger.getLogger(EmployeeController.class.getName());
	 
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value="/get")
	public String  getEmployees(){
		LOG.info("I am inside the Method getEmployee");
		return "Its Working ";

	}

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public int addEmployee(@RequestBody Employee employee){
		employeeService.saveOrUpdate(employee);
		return employee.getId();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("id") Integer id) { 
		employeeService.deleteEmployeeById(id);

	}


	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public int updateEmployee(@PathVariable("id") Integer
			id, @RequestBody Employee employee) { 

		employeeService.saveOrUpdate(employee);
		return employee.getId();
	}


}
