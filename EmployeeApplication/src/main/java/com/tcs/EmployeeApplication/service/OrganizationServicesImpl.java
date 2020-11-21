package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.EmployeeApplication.dao.DepartmentDao;
import com.tcs.EmployeeApplication.dao.DepartmentDaoImpl;
import com.tcs.EmployeeApplication.dao.OrganizationDao;
import com.tcs.EmployeeApplication.dao.OrganizationDaoImpl;
import com.tcs.EmployeeApplication.model.Department;
import com.tcs.EmployeeApplication.model.Employee;
import com.tcs.EmployeeApplication.model.Organization;
import com.tcs.EmployeeApplication.repository.OrganizationRepository;
@Service
public class OrganizationServicesImpl implements OrganizationServices {
	@Autowired
	OrganizationRepository organizationRepository; 
	@Override
	public String addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		/*Long id=organization.getId();
		List<Employee> employees=orgdao.findEmpByOrganization(id);
		List<Department> departments=orgdao.findByOrganizationId(id);
		organization.setDepartments(departments);
		organization.setEmployees(employees);*/
		Organization org=null;
		try {
			org=organizationRepository.save(organization);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}
	}

	

	@Override
	public String deleteOrganization(Long id) {
		// TODO Auto-generated method stub
		
		organizationRepository.deleteById(id);
		return "success";
	}

	@Override
	public Optional<Organization> findById(Long id) {
		// TODO Auto-generated method stub
		return organizationRepository.findById(id);
	}

	@Override
	public Optional<List<Organization>> getOrganizations() {
		// TODO Auto-generated method stub
		
		return Optional.ofNullable(organizationRepository.findAll());
	}

}
