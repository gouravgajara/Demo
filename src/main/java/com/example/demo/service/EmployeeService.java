package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service 
public class EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.delete(id);;
    }

    public void saveOrUpdate(Employee employee) {
    	employeeRepository.save(employee);
    }

	
	

}
