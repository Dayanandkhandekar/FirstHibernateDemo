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

public class SecondInheritanceDemo {
  public static void main(String[] args) {
	  System.out.println("===start=== ");
	  Configuration con=new Configuration();
	 SessionFactory sf= con.configure("hibernate.cfg.xml").buildSessionFactory();
	 
	    Session session=sf.openSession();
	// Session session= sf.getCurrentSession();
	    System.out.println("session==="+session);
	  Transaction  tr=session.beginTransaction();
	    Emp e1=new Emp(1, "AA");
	    
	    PEMP11 p1=new PEMP11(2, "BB", "Infosys", 20000);
	    
	    CEMP11 c1=new CEMP11(3, "CC", 2);
	    session.merge(e1);
	    session.merge(p1);
	    session.merge(c1);
	    tr.commit();
	    
	    System.out.println("====EOF PGM====");
}
}
@Entity
@Table(name = "EMP_INFO")
@Inheritance(strategy = InheritanceType.JOINED)
class Emp {
	@Id
   int empId;
   String empName;
/**
 * @param empId
 * @param empName
 */
	public Emp(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}
   

public Emp() {
	
   }


@Override
public String toString() {
	return "Emp [empId=" + empId + ", empName=" + empName + "]";
}


}
@Entity
@Table(name = "EMP_PINFO")
class PEMP11 extends Emp{
	String companyName;
	double salray;

	
	
	/**
	 * @param empId
	 * @param empName
	 * @param companyName
	 * @param salray
	 */
	public PEMP11(int empId, String empName, String companyName, double salray) {
		super(empId, empName);
		this.companyName = companyName;
		this.salray = salray;
	}



	@Override
	public String toString() {
		return "PEMP [companyName=" + companyName + ", salray=" + salray + ", empId=" + empId + ", empName=" + empName
				+ "]";
	}



	public PEMP11() {
		
	}
	
}
@Entity
@Table(name = "EMP_CINFO")
class CEMP11 extends Emp {
	int duration;

	/**
	 * @param empId
	 * @param empName
	 * @param duration
	 */
	public CEMP11(int empId, String empName, int duration) {
		super(empId, empName);
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "CEMP [duration=" + duration + "]";
	}
	public CEMP11() {
		
	}
}

