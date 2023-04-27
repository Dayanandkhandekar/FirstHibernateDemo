package com.startpgm;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.entity.Office;
import com.entity.Student;
import com.javabasedconfiguration.HibernateUtilJava;



public class StartPgm {
	
   public static void main(String[] args) {
	 
	  // officeInfo();
	     saveStudentInfo();
	     
}
   
   
 static   void  saveStudentInfo(){
	   SessionFactory sf = HibernateUtilJava.getSessionFactory();
	   Student s1=new Student(1, "AA",10);
	   Transaction  tr =sf.getCurrentSession().beginTransaction();
	    Object result = sf.getCurrentSession().merge(s1);
	    tr.commit();
	         System.out.println("result========"+result);
    }
 
 static void  officeInfo() {
	   SessionFactory sf = HibernateUtilJava.getSessionFactory();
	   System.out.println("Inside office info");
	 Employee e1=new Employee(1, "AA");
	 Employee e2=new Employee(2, "BA");
	 Employee e3=new Employee(3, "CA");
	 Employee e4=new Employee(4, "DA");
	 
	 List<Employee> list1=new ArrayList<Employee> ();
	     list1.add(e1);
	     list1.add(e2);
	     
	     List<Employee> list2=new ArrayList<Employee> ();
	     list2.add(e4);
	     list2.add(e3);
	     
	     Office o1=new Office(1, "Pune","411018", list1);
	     
	     Office o2=new Office(2, "Mumbai","411019", list2);
	     
	  
	     Transaction  tr =sf.getCurrentSession().beginTransaction();
	     tr.begin();
		   sf.openSession().merge(o1);
		   sf.getCurrentSession().merge(o2);
		    tr.commit();
	  
 }
} 
