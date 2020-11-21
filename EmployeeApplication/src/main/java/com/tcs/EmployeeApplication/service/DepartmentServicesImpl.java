package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.EmployeeApplication.model.Department;

import com.tcs.EmployeeApplication.repository.DepartmentRepository;

@Service
public class DepartmentServicesImpl implements DepartmentServices {
	

	
	@Autowired
	DepartmentRepository departmentRepository;
	
		
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		/*Long id=department.getId();
		List<Employee> employees=deptdao.findEmpByDepartment(id);
		department.setEmployees(employees);*/
		Department department1=null;
		try {
			department1=departmentRepository.save(department);
			return "success";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	
	}

	
	@Override
	public String deleteDepartment(Long id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
		return "success";
	}

	@Override
	public Optional<Department> findById(Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id);
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(departmentRepository.findAll());
	}

	@Override
	public Optional<List<Department>> findByOrganizationId(Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findByOrganizationid(id);
	}

}
