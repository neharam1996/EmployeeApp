
package com.tcs.EmployeeApplication.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	@Id
	private Long id;
	private Long organizationid;
	private String name;
	//@Lazy
	//private List<Employee> employees;
	@ManyToOne
	@JoinColumn(name="organization_id")
	private Organization organization;
	
}
