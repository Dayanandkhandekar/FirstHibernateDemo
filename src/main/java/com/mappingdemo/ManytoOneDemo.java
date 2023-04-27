package com.mappingdemo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManytoOneDemo {
   public static void main(String[] args) {
	   System.out.println("===start=== ");
		  Configuration con=new Configuration();
		 SessionFactory sf= con.configure("hibernate.cfg.xml").buildSessionFactory();
		 
		    Session session=sf.openSession();
		// Session session= sf.getCurrentSession();
		    System.out.println("session==="+session);
		     Transaction tr=session.beginTransaction();
		     
		     Company c1=new Company(1, "Info", "Pune");
		     Company c2=new Company(2, "Tech M", "Mumbai");
		     
		     Employee e1=new Employee(1, "AA", "pune", c1);
		     Employee e2=new Employee(2, "BA", "pune", c1);
		     Employee e3=new Employee(3, "CA", "Mumbai", c2);
		     Employee e4=new Employee(4, "DA", "Mumbai", c2);
		     
		     session.merge(e1);
		     session.merge(e2);
		     session.merge(e3);
		     session.merge(e4);
		     tr.commit();
		     
		     System.out.println("=====EOP=====");
}
} 
@Entity
@Table(name = "EMPLOYEE_COMPANY")
class Employee {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  int empId;
	  String empName;
	  String empAddress;
	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "company_id")
	  Company c;
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", c=" + c + "]";
	}
	/**
	 * @param empId
	 * @param empName
	 * @param empAddress
	 * @param c
	 */
	public Employee(int empId, String empName, String empAddress, Company c) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.c = c;
	}
	  
	public Employee() {
		
	}
	
}

@Entity
@Table(name = "COMPANY_INFO")
class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	int companyId;
	@Column(name = "company_name")
	String ompanyName;
	@Column(name = "company_address")
	String companyAddress;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getOmpanyName() {
		return ompanyName;
	}
	public void setOmpanyName(String ompanyName) {
		this.ompanyName = ompanyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", ompanyName=" + ompanyName + ", companyAddress=" + companyAddress
				+ "]";
	}
	/**
	 * @param companyId
	 * @param ompanyName
	 * @param companyAddress
	 */
	public Company(int companyId, String ompanyName, String companyAddress) {
		super();
		this.companyId = companyId;
		this.ompanyName = ompanyName;
		this.companyAddress = companyAddress;
	}
	
	public Company() {
		
	}
	
	
}
