package com.tcs.EmployeeApplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.EmployeeApplication.model.Employee;
import com.tcs.EmployeeApplication.util.DBUtils;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	DBUtils dbUtils;
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String addquery="insert into EMPLOYEE (id,organizationid,departmentid,name,age,position) values(?,?,?,?,?,?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(addquery);
			preparedStatement.setLong(1, employee.getId());
			preparedStatement.setLong(2, employee.getOrganizationid());
			preparedStatement.setLong(3, employee.getDepartmentid());
			preparedStatement.setString(4, employee.getName());
			preparedStatement.setInt(5, employee.getAge());
			preparedStatement.setString(6, employee.getPosition());
			result=preparedStatement.executeUpdate();
			if(result>0) {
				connection.commit();
				return "success";
			}
			else {
				return "fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}

	public String updateEmployee(long id,String name) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String updatequery="update  EMPLOYEE set name=? where id=?";
		try {
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(updatequery);
			preparedStatement.setString(1, name);
			preparedStatement.setLong(2, id);
			
			result=preparedStatement.executeUpdate();
			if(result>0) {
				connection.commit();
				return "success";
			}
			else {
				return "fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}

	public String deleteEmployee(long id) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String deletequery="delete from EMPLOYEE where id=?";
		try {
			connection.setAutoCommit(false);

			preparedStatement=connection.prepareStatement(deletequery);
			preparedStatement.setLong(1,id);
			
			result=preparedStatement.executeUpdate();
			if(result>0) {
				connection.commit();
				return "success";
			}
			else {
				return "fail";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
	}

	public Optional<Employee> findById(long id) {
		// TODO Auto-generated method stub
	Connection connection=dbUtils.getConnection();
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
		Employee employee=null;
		String findquery="select * from EMPLOYEE where id=?";
		try {
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(findquery);
			preparedStatement.setLong(1, id);
			
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				employee=new Employee();
				employee.setId(resultSet.getLong("id"));
				employee.setOrganizationid(resultSet.getLong("organizationid"));
				employee.setDepartmentid(resultSet.getLong("departmentid"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.of(employee);
			
	}

	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Employee employee=null;
		List<Employee> employeelist=new ArrayList<Employee>();
		String findAllquery="select * from EMPLOYEE";
		try {
			connection.setAutoCommit(false);

			preparedStatement=connection.prepareStatement(findAllquery);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				employee=new Employee();
				employee.setId(resultSet.getLong("id"));
				employee.setOrganizationid(resultSet.getLong("organizationid"));
				employee.setDepartmentid(resultSet.getLong("departmentid"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));
				employeelist.add(employee);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.of(employeelist);
		
	}

	public Optional<List<Employee>> findByOrganization(long id) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Employee employee=null;
		List<Employee> employeelist=new ArrayList<Employee>();
		String findOrgquery="select * from EMPLOYEE where organizationid=?";
		try {
			connection.setAutoCommit(false);

			preparedStatement=connection.prepareStatement(findOrgquery);
			preparedStatement.setLong(1, id);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				employee=new Employee();
				employee.setId(resultSet.getLong("id"));
				employee.setOrganizationid(resultSet.getLong("organizationid"));
				employee.setDepartmentid(resultSet.getLong("departmentid"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPosition(resultSet.getString("position"));
				employeelist.add(employee);
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return Optional.empty();
		
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.of(employeelist);
		
	}
	

}
