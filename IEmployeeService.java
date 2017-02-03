package com.cg.service;

import java.util.List;

import com.cg.exceptions.EMSException;
import com.cg.models.Employee;

public interface IEmployeeService {

	int add(Employee e) throws EMSException;
	
	List<Employee> getAll() throws EMSException;
	
	void update(Employee e);
}
