package com.tcs.EmployeeApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.EmployeeApplication.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public Optional<List<Employee>> findByOrganizationid(Long id);

}
