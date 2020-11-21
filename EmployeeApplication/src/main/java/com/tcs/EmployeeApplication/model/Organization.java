package com.tcs.EmployeeApplication.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
@Id
private Long id;
private String name;
private String address;

@OneToMany(mappedBy="organization",cascade=CascadeType.ALL)
private List<Department> departments;

//private List<Employee> employees=new ArrayList<>();


}
