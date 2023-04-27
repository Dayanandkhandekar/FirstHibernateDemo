package com.inheritancedemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ThirdInheritanceDemo {
  public static void main(String[] args) {
	  System.out.println("===start=== ");
	  Configuration con=new Configuration();
	 SessionFactory sf= con.configure("hibernate.cfg.xml").buildSessionFactory();
	 
	    Session session=sf.openSession();
	// Session session= sf.getCurrentSession();
	    System.out.println("session==="+session);
	  Transaction  tr=session.beginTransaction();
	  
	  Parent p1=new Parent(1, "AA", "1111111");
	  
	  Child1 c1=new Child1(2, "BB", "222222", "LT", 30000);
	  
	  Child2 c2=new Child2(3, "CC", "3333333",5);
	  session.merge(p1);
	  session.merge(c1);
	  session.merge(c2);
	  tr.commit();
	  
	  System.out.println("=====EOF PGM====");
	  
	  
}
}

@Entity
@Table(name="PARENT_INFO")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class Parent {
	@Id
	int id;
	String name;
	String mobile;
	/**
	 * @param id
	 * @param name
	 * @param mobile
	 */
	public Parent(int id, String name, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Parent [id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
	}
	
	public Parent() {
		
	}
	
}
@Entity
@Table(name="CHILD1_INFO")
class Child1 extends Parent {
	 
	String  companyName;
	double salary;
	/**
	 * @param id
	 * @param name
	 * @param mobile
	 * @param companyName
	 * @param salary
	 */
	public Child1(int id, String name, String mobile, String companyName, double salary) {
		super(id, name, mobile);
		this.companyName = companyName;
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "Child1 [companyName=" + companyName + ", salary=" + salary + ", id=" + id + ", name=" + name
				+ ", mobile=" + mobile + "]";
	}


	public Child1() {
		
	}
	
	  
}
@Entity
@Table(name="CHILD2_INFO")
class Child2 extends Parent {
	int duration;

	/**
	 * @param id
	 * @param name
	 * @param mobile
	 * @param duration
	 */
	public Child2(int id, String name, String mobile, int duration) {
		super(id, name, mobile);
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Child2 [duration=" + duration + ", id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
	}
	
	public Child2() {
		
		
	}
}
