package com.cg.dao;

import java.util.List;

import com.cg.exceptions.EMSException;
import com.cg.models.Employee;

public interface IEmployeeDAO {
	
	int add(Employee e) throws EMSException;
	
	List<Employee> getAll() throws EMSException;
	
	void update(Employee e) throws EMSException;

	Employee search(int empId)throws EMSException;
}
