package com.tcs.EmployeeApplication;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.EmployeeApplication.config.DBConfig;
import com.tcs.EmployeeApplication.model.Department;
import com.tcs.EmployeeApplication.model.Employee;
import com.tcs.EmployeeApplication.model.Organization;
import com.tcs.EmployeeApplication.service.DepartmentServices;
import com.tcs.EmployeeApplication.service.EmployeeServices;

import com.tcs.EmployeeApplication.service.OrganizationServices;


public class Main {
	@Transactional
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
		EmployeeServices empservices=context.getBean(EmployeeServices.class);
		DepartmentServices deptservices=context.getBean(DepartmentServices.class);
		OrganizationServices orgservices=context.getBean(OrganizationServices.class);
		Organization org=new Organization(20L,"mgit","nel",null);
		Department dept1=new Department(55L,20L,"CS",org);
		Department dept2=new Department(56L,20L,"IT",org);
		orgservices.addOrganization(org);
		
		deptservices.addDepartment(dept1);
		deptservices.addDepartment(dept2);
		List<Department> abc=new ArrayList<Department>();
		abc.add(dept1);
		abc.add(dept2);
		org.setDepartments(abc);
		
		
		
		System.out.println();
		System.out.println(orgservices.findById(20L));
		/*System.out.println("Select an operation you want to perform on Organization\n.1.add\n2.delete\n3.findbyid.\n4.findall");
		 Scanner input2 = new Scanner(System.in);
		 int ans2=input2.nextInt();
		 switch(ans2) {
		 	case 1:{Long id=input2.nextLong();
		 			
		 			String name=input2.next();
		 			String address=input2.next();
		 			Organization org=new Organization(id,name,address,null);
		 			System.out.println(orgservices.addOrganization(org));
		 		
		 			break;}
		 	case 2:{Long id=input2.nextLong();
		 	System.out.println(orgservices.deleteOrganization(id));
		 			break;}
		 	case 3:{Long id=input2.nextLong();
		 	System.out.println(orgservices.findById(id));
 				break;}
		 	case 4:{System.out.println(orgservices.getOrganizations());break;}
		 	
		 	default:
		
		
		 }
		System.out.println("Select an operation you want to perform on Department\n.1.add\n2.delete\n3.findbyid.\n4.findall\n5.findbyorgid\n6.update");
		 Scanner input1 = new Scanner(System.in);
		 int ans1=input1.nextInt();
		 switch(ans1) {
		 	case 1:{Long id=input1.nextLong();
		 			Long orgid=input1.nextLong();
		 			String name=input1.next();
		 			Optional<Organization> optional=orgservices.findById(orgid);
					Organization org=optional.get();
					Department dept=new Department(id,orgid,name,org);
					org.getDepartments().add(dept);
					System.out.println(deptservices.addDepartment(dept));
		 			break;}
		 	case 2:{Long id=input1.nextLong();
		 	System.out.println(deptservices.deleteDepartment(id));
		 			break;}
		 	case 3:{Long id=input1.nextLong();
		 	System.out.println(deptservices.findById(id));
 				break;}
		 	case 4:{System.out.println(deptservices.getDepartments());break;}
		 	case 5:{Long id=input1.nextLong();
		 	System.out.println(deptservices.findByOrganizationId(id));
		 	break;
		 	}
		 	default:
		
		 	
		
		
		 }
		System.out.println("Select an operation you want to perform on Employee\n.1.add\n2.delete\n3.findbyid.\n4.findall\n5.findbyorgid\n6.update");
		 Scanner input = new Scanner(System.in);
		 int ans=input.nextInt();
		 switch(ans) {
		 	case 1:{Long id=input.nextLong();
		 			Long orgid=input.nextLong();
		 			Long deptid=input.nextLong();
		 			String name=input.next();
		 			int age=input.nextInt();
		 			String position=input.next();
		 			Employee employee=new Employee(id,orgid,deptid,name,age,position);
		 			System.out.println(empservices.addEmployee(employee));
		 			break;}
		 	case 2:{Long id=input.nextLong();
		 			System.out.println(empservices.deleteEmployee(id));
		 			break;}
		 	case 3:{Long id=input.nextLong();
 				System.out.println(empservices.findById(id));
 				break;}
		 	case 4:{System.out.println(empservices.getEmployees());break;}
		 	case 5:{Long id=input.nextLong();
		 			System.out.println(empservices.findByOrganization(id));break;
		 	
		 	}
		 	case 6:{Long id=input.nextLong();
 			
 			String name=input.next();
 			System.out.println(empservices.updateEmployee(id, name));break;}
		 	default:
		
		
		 }*/
		 context.close();
		 
		
		
		
		
	}
}
