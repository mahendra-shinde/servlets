package com.cg.dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;

import com.cg.exceptions.EMSException;
import com.cg.models.Employee;
import com.cg.util.DBUtil;

public class EmployeeDAO implements IEmployeeDAO {

	private static final String INSERT_QUERY
			="INSERT into emp2(empid,ename,gender,designation,phone,email) "+  
				"   values(emp_seq2.nextval, ?,?,?,?,?)";
	private static final String GET_ALL_QUERY
			="select empid,ename,gender,designation,phone,email from emp2";

	private static final String UPDATE_QUERY
		= "update emp2 set ename=?, gender=?, "
		+ "  designation=?, phone=?, email=? where empid=?";

	private static final String SELECT_QUERY=
				"select empid,ename,gender,designation,phone,email from emp2 where empid=?";
	
	@Override
	public int add(Employee e) throws EMSException{
		try{
			Connection con = DBUtil.obtainConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1,e.getName());
			ps.setString(2, e.getGender());
			ps.setString(3,e.getDesignation());
			ps.setString(4,e.getPhone());
			ps.setString(5, e.getEmail());
			ps.executeUpdate();
			int id =0;
			//Get generated Primary key:
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select emp_seq2.currval from dual");
			if(rs.next()){				
				id = rs.getInt(1);
				System.out.println("SEQ value "+id);
			}
			con.close();
			return id;
		}catch(NamingException | SQLException ex){
			throw new EMSException("Unable to save, "+ex.getMessage());
		}
	}

	@Override
	public List<Employee> getAll()throws EMSException {
		try{
			Connection con = DBUtil.obtainConnection();
			PreparedStatement ps = con.prepareStatement(GET_ALL_QUERY);
			ResultSet rs = ps.executeQuery();
			//Create EMPTY list
			List<Employee> emps = new LinkedList<>();
			//Get ONE record at a time
			while(rs.next()){
				Employee e = new Employee();
				//Store ALL values into Employee Object
				//"e" is now D.T.O.
				e.setEmpId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setDesignation(rs.getString(4));
				e.setPhone(rs.getString(5));
				e.setEmail(rs.getString(6));
				//Add DTO into LIST
				emps.add(e);
			}
			con.close();
			//return LIST
			return emps;
		}catch(NamingException | SQLException ex){
			throw new EMSException("Unable to fetch records, "+ex.getMessage());
		}
	}

	@Override
	public void update(Employee e)throws EMSException {
		try{
			Connection con = DBUtil.obtainConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);//CHANGE
			ps.setString(1,e.getName());
			ps.setString(2, e.getGender());
			ps.setString(3,e.getDesignation());
			ps.setString(4,e.getPhone().trim());
			ps.setString(5, e.getEmail().trim());
			ps.setInt(6, e.getEmpId());//NEW-ADDITION
			ps.executeUpdate();
			
			con.close();
			
		}catch(NamingException | SQLException ex){
			ex.printStackTrace(System.out);
			throw new EMSException("Unable to save, "+ex.getMessage());
		}
		
	}

	@Override
	public Employee search(int empId) throws EMSException {
		try{
			Connection con = DBUtil.obtainConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			Employee e = new Employee();
			
			//Get ONE record at a time
			if(rs.next()){
				//Store ALL values into Employee Object
				//"e" is now D.T.O.
				e.setEmpId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setDesignation(rs.getString(4));
				e.setPhone(rs.getString(5));
				e.setEmail(rs.getString(6));

			}
			con.close();
			//return LIST
			return e; //return object to service
		}catch(NamingException | SQLException ex){
			throw new EMSException("Unable to fetch records, "+ex.getMessage());
		}
		
		
		
	}
	
	

}
