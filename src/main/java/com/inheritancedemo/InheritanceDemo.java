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

public class InheritanceDemo {
   public static void main(String[] args) {
	   System.out.println("===start=== ");
		  Configuration con=new Configuration();
		 SessionFactory sf= con.configure("hibernate.cfg.xml").buildSessionFactory();
		 
		    Session session=sf.openSession();
		// Session session= sf.getCurrentSession();
		    System.out.println("session==="+session);
		  //  A a1=new A(1, "AA");
		   // B b1=new B(2, "BB", 10);
		    C c1=new C(4, "CCC", 2200);
		   Transaction tr=session.beginTransaction();
		   //session.merge(a1);
		  // session.merge(b1);
		   session.merge(c1);
		   tr.commit();
		   
		   System.out.println("====End====");
}
}

@Entity
@Table(name = "AA_Table")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class A {
	@Id
	int id;
	String name;
	/**
	 * @param id
	 * @param name
	 */
	public A(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "A [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public A() {
		
	}
	
}
@Entity
@Table(name = "B_Table")
class B extends A {
	int mark;

	/**
	 * @param id
	 * @param name
	 * @param mark
	 */
	public B(int id, String name, int mark) {
		super(id, name);
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "B [mark=" + mark + ", id=" + id + ", name=" + name + "]";
	}
	
public B() {
		
	}
	
}
@Entity
@Table(name = "C_Table")
class C extends A {
	double slaray;

	/**
	 * @param id
	 * @param name
	 * @param slaray
	 */
	public C(int id, String name, double slaray) {
		super(id, name);
		this.slaray = slaray;
	}

	@Override
	public String toString() {
		return "C [slaray=" + slaray + ", id=" + id + ", name=" + name + "]";
	}

	
public C() {
		
	}
	
}
