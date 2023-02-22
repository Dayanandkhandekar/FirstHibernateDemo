package com.criteriademo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class CriteriaDemo {
	public static void main(String[] args) {
		 System.out.println("===start=== ");
		  Configuration con=new Configuration();
		 SessionFactory sf= con.configure("hibernate.cfg.xml").buildSessionFactory();
		 
		    Session session=sf.openSession();
		// Session session= sf.getCurrentSession();
		    System.out.println("session==="+session);
		     Transaction tr=session.beginTransaction();
		     
		     Employee e1=new Employee(1, "Abc",200);
		     Employee e2=new Employee(2, "PQR",2200);
		     Employee e3=new Employee(3, "XYZ",1200);
		     Employee e4=new Employee(4, "Abc1",4200);
		     
		     session.merge(e1);
		     session.merge(e2);
		     session.merge(e3);
		     session.merge(e4);
		     tr.commit();
		     
		      // Employee obj = session.get(Employee.class, 2);//select * from emp_data where empId=2;
		          
		       Criteria c = session.createCriteria(Employee.class);
		         
		       // List list = c.list();//select * from emp_data 
		      //  System.out.println("list===="+list);
		       
		       c.add(Restrictions.ge("employeeSalaray", 200.0));//select * from emp_data where employeeSalaray > 1000;
		         
		       List list= c.list();
		       System.out.println("list===="+list);
		     System.out.println("====EOP======");
	}
	
}
@Entity
@Table(name = "EMP_DATA")
class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int empId;
	String empName;
	
	@Column(name = "emp_salary")
	double employeeSalaray;
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", employeeSalaray=" + employeeSalaray + "]\n";
	}
	/**
	 * @param empId
	 * @param empName
	 * @param employeeSalaray
	 */
	public Employee(int empId, String empName, double employeeSalaray) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.employeeSalaray = employeeSalaray;
	}
	
	public Employee() {
		
	}
	
}
