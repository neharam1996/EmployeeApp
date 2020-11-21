package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeApplication.model.Department;

public interface DepartmentServices {
	public String addDepartment(Department department);
	
	public String deleteDepartment(Long id);
	public Optional<Department> findById(Long id);
	public Optional<List<Department>> getDepartments();
	public Optional<List<Department>> findByOrganizationId(Long id);
}
