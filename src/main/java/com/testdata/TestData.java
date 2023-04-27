package com.testdata;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class TestData {
	public static void main(String[] args) {
		  System.out.println("===start1112=== ");
		  Configuration con=new Configuration();
		 SessionFactory sf= con.configure("hibernate.cfg.xml").buildSessionFactory();
		 
		    Session session=sf.openSession();
		// Session session= sf.getCurrentSession();
		    System.out.println("session==="+session);
		    Student s1=new Student(1, "AA1", 1100,"pune");
		    Student s2=new Student(2, "AAA2", 1200,"pune");
		    Student s3=new Student(3, "AAAA3", 1300,"pune");
		    Student s4=new Student(8, "AAAA4", 300,"Mumbai1");
		  Transaction  tr=session.beginTransaction();
		    //session.save(s1);
		   // session.save(s2);
		    tr.commit();
		   // session.save(s3);
		    // session.update(s1);
		     //session.update(s2);
		    // session.update(s4);
		 // session.merge(s4);
		  
		   // Student obj=session.get(Student.class, 8);//select * from student where student_id=8
		   
		 //  Student obj     =session.load(Student.class, 8);
		  // System.out.println("load====="+obj);
		   
		  Student obj     =session.get(Student.class, 1);
		   System.out.println("get====="+obj);
		   
		   Student obj2     =session.get(Student.class, 1);
		   System.out.println("get2====="+obj2);
		   
		   
		   Session session2=sf.openSession();
		   Student seobj2     =session2.get(Student.class, 1);
		   System.out.println("seobj2 get====="+seobj2);
		// Student obj1     =session.load(Student.class, 8);
		 // System.out.println("load====="+obj1);
		  
		 // Student obj2     =session.load(Student.class, 8);
		 // System.out.println("obj2 load====="+obj2);
		   
		    //
		      System.out.println("===End ===");
		
	}
}
