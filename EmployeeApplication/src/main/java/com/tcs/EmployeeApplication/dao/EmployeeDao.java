package com.tcs.EmployeeApplication.dao;

import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeApplication.model.Employee;

public interface EmployeeDao {
	public String addEmployee(Employee employee);
	public String updateEmployee(long id,String name);
	public String deleteEmployee(long id);
	public Optional<Employee> findById(long id);
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Employee>> findByOrganization(long id);
	
	
}
