package com.tcs.EmployeeApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_tbl")
public class Employee {
	@Id
	private Long id;
	private Long organizationid;
	private Long departmentid;
	private String name;
	private int age;
	private String position;
	

}
