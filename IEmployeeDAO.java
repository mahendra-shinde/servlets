package com.cg.dao;

import java.util.List;

import com.cg.exceptions.EMSException;
import com.cg.models.Employee;

public interface IEmployeeDAO {
	
	void add(Employee e) throws EMSException;
	
	List<Employee> getAll() throws EMSException;
	
	void update(Employee e);
}
