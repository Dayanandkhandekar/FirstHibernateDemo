package com.mappingdemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoManyDemo {
   public static void main(String[] args) {
	   System.out.println("===start=== ");
		  Configuration con=new Configuration();
		 SessionFactory sf= con.configure("hibernate.cfg.xml").buildSessionFactory();
		 
		    Session session=sf.openSession();
		// Session session= sf.getCurrentSession();
		    System.out.println("session==="+session);
		     Transaction tr=session.beginTransaction();
		    
		     Bank b1=new Bank(1, "11111", "BOM");
		     Bank b2=new Bank(2, "211111", "BOI");
		     Bank b3=new Bank(3, "311111", "SBI");
		     Bank b4=new Bank(4, "411111", "BOB");
		     
		     List<Bank> lst1=new ArrayList<Bank>();
		       lst1.add(b1);
		       lst1.add(b2);
		       
		       List<Bank> lst2=new ArrayList<Bank>();
		       lst2.add(b3);
		       lst2.add(b4);
		       
		       Customer c1=new Customer(1, "AA", "111111", lst1);
		       
		       Customer c2=new Customer(2, "AA", "2111111", lst2);
		       
		       session.merge(c1);
		       session.merge(c2);
		       tr.commit();
		       
		       System.out.println("====EOP=======");
		       
}
}

@Entity
@Table(name = "CUSTOMER_INFO")
class Customer {
	   @Id
	  @Column(name = "cust_id")
	  int custId;
	   @Column(name = "cust_name")
	  String custName;
	   @Column(name = "cust_mb")
	  String custMb;
	   
	   @OneToMany(cascade = CascadeType.ALL)
	   @JoinColumn(name = "customer_id")
	   List<Bank> lstBank;

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custMb=" + custMb + ", lstBank=" + lstBank
				+ "]\n";
	}

	/**
	 * @param custId
	 * @param custName
	 * @param custMb
	 * @param lstBank
	 */
	public Customer(int custId, String custName, String custMb, List<Bank> lstBank) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custMb = custMb;
		this.lstBank = lstBank;
	}
	   
	 public Customer() {
		 
	 }  
	   
	   
	
}
@Entity
@Table(name = "BANK_INFO")

class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_id")
	int bankId;
	@Column(name = "bank_account_number")
	String backAccountNumber;
	@Column(name = "bank_name")
	String bankName;
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", backAccountNumber=" + backAccountNumber + ", bankName=" + bankName + "]\n";
	}
	/**
	 * @param bankId
	 * @param backAccountNumber
	 * @param bankName
	 */
	public Bank(int bankId, String backAccountNumber, String bankName) {
		super();
		this.bankId = bankId;
		this.backAccountNumber = backAccountNumber;
		this.bankName = bankName;
	}
	
	public Bank() {
		
	}
	
}
