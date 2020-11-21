package com.tcs.EmployeeApplication.service;

import java.util.List;
import java.util.Optional;

import com.tcs.EmployeeApplication.model.Organization;

public interface OrganizationServices {
	public String addOrganization(Organization organization);
	
	public String deleteOrganization(Long id);
	public Optional<Organization> findById(Long id);
	public Optional<List<Organization>> getOrganizations();
}
