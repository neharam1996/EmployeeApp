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

import com.tcs.EmployeeApplication.model.Department;
import com.tcs.EmployeeApplication.model.Employee;
import com.tcs.EmployeeApplication.util.DBUtils;
@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	DBUtils dbUtils;
	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String addquery="insert into DEPARTMENT (id,orgnizationid,name) values(?,?,?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(addquery);
			preparedStatement.setLong(1,department.getId());
			preparedStatement.setLong(2, department.getOrganizationid());
			preparedStatement.setString(3, department.getName());
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

	@Override
	public String updateDepartment(Long id,String name) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String updatequery="update  DEPARTMENT set name=? where id=?";
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

	@Override
	public String deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String deletequery="delete from DEPARTMENT where id=?";
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

	@Override
	public Optional<Department> findById(Long id) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			Department department=null;
			String findquery="select * from DEPARTMENT where id=?";
			try {
				connection.setAutoCommit(false);
				preparedStatement=connection.prepareStatement(findquery);
				preparedStatement.setLong(1, id);
				
				resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
					department=new Department();
					department.setId(resultSet.getLong("id"));
					department.setOrganizationid(resultSet.getLong("orgnizationid"));
					department.setName(resultSet.getString("name"));
					
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
			return Optional.of(department);
				
		}
		

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Department department=null;
		List<Department> departmentlist=new ArrayList<Department>();
		String findAllquery="select * from DEPARTMENT";
		try {
			connection.setAutoCommit(false);

			preparedStatement=connection.prepareStatement(findAllquery);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				department=new Department();
				department.setId(resultSet.getLong("id"));
				department.setOrganizationid(resultSet.getLong("orgnizationid"));
				department.setName(resultSet.getString("name"));
				departmentlist.add(department);
				
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
		return Optional.of(departmentlist);
		
	}

	@Override
	public Optional<List<Department>> findByOrganizationId(Long id) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Department department=null;
		List<Department> departmentlist=new ArrayList<Department>();
		String findAllquery="select * from DEPARTMENT where orgnizationid=?";
		try {
			connection.setAutoCommit(false);

			preparedStatement=connection.prepareStatement(findAllquery);
			preparedStatement.setLong(1, id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				department=new Department();
				department.setId(resultSet.getLong("id"));
				department.setOrganizationid(resultSet.getLong("orgnizationid"));
				department.setName(resultSet.getString("name"));
				departmentlist.add(department);
				
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
		return Optional.of(departmentlist);
	}
	
	public List<Employee> findEmpByDepartment(Long id) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Employee employee=null;
		List<Employee> employeelist=new ArrayList<Employee>();
		String findOrgquery="select * from EMPLOYEE where departmentid=?";
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
			
		
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return employeelist;
		
	}

}
