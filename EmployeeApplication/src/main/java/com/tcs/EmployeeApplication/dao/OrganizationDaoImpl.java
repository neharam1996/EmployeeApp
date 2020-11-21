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
import com.tcs.EmployeeApplication.model.Organization;
import com.tcs.EmployeeApplication.util.DBUtils;
@Repository
public class OrganizationDaoImpl implements OrganizationDao {
	@Autowired
	DBUtils dbUtils;
	
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String addquery="insert into ORGANIZATION (id,name,address) values(?,?,?)";
		try {
			connection.setAutoCommit(false);
			preparedStatement=connection.prepareStatement(addquery);
			preparedStatement.setLong(1,organization.getId());
			
			preparedStatement.setString(2, organization.getName());
			preparedStatement.setString(3, organization.getAddress());
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
	public String updateOrganization(Long id,String name) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String updatequery="update ORGANIZATION set name=? where id=?";
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
	public String deleteOrganization(Long id) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		int result=0;
		String deletequery="delete from ORGANIZATION where id=?";
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
	public Optional<Organization> findById(Long id) {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
			Organization organization=null;
			String findquery="select * from ORGANIZATION where id=?";
			try {
				connection.setAutoCommit(false);
				preparedStatement=connection.prepareStatement(findquery);
				preparedStatement.setLong(1, id);
				
				resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
					organization=new Organization();
					organization.setId(resultSet.getLong("id"));
					organization.setName(resultSet.getString("name"));
					organization.setAddress(resultSet.getString("address"));
					
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
			return Optional.of(organization);
				
		}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		Connection connection=dbUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Organization organization=null;
		List<Organization> organizationlist=new ArrayList<Organization>();
		String findAllquery="select * from ORGANIZATION";
		try {
			connection.setAutoCommit(false);

			preparedStatement=connection.prepareStatement(findAllquery);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				organization=new Organization();
				organization.setId(resultSet.getLong("id"));
				organization.setName(resultSet.getString("name"));
				organization.setAddress(resultSet.getString("address"));
				organizationlist.add(organization);
				
				
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
		return Optional.of(organizationlist);
		
	}
	public List<Department> findByOrganizationId(Long id) {
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
			
		
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return departmentlist;
	}
	public List<Employee> findEmpByOrganization(Long id) {
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
			
		
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return employeelist;
		
	}



}
