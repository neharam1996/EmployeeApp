package com.tcs.EmployeeApplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcs.EmployeeApplication.model.Organization;
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
