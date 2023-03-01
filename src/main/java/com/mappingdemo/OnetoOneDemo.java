package com.mappingdemo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoOneDemo {
   public static void main(String[] args) {
	   System.out.println("===start=== ");
		  Configuration con=new Configuration();
		 SessionFactory sf= con.configure("hibernate.cfg.xml").buildSessionFactory();
		 
		    Session session=sf.openSession();
		// Session session= sf.getCurrentSession();
		    System.out.println("session==="+session);
		     Transaction tr=session.beginTransaction();
		     AdharInfo ad1=new AdharInfo(111,"Pune");
		     AdharInfo ad2=new AdharInfo(222,"Mumbai");
		     
		     Person p1=new Person(1, "AA", "1111111",ad1);
		     Person p2=new Person(2, "BB", "222222",ad2);
		     session.merge(p1);
		     session.merge(p2);
		     tr.commit();
		     
		     System.out.println("====EOP=====");
}
}

@Entity
@Table(name="PERSON_INFO")
class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="person_id")
	int personId;
	@Column(name="person_name")
	String personName;
	@Column(name="person_mobile")
	String personMb;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adhar_no")
	AdharInfo ad;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonMb() {
		return personMb;
	}

	public void setPersonMb(String personMb) {
		this.personMb = personMb;
	}

	public AdharInfo getAd() {
		return ad;
	}

	public void setAd(AdharInfo ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personMb=" + personMb + ", ad=" + ad
				+ "]";
	}

	/**
	 * @param personId
	 * @param personName
	 * @param personMb
	 * @param ad
	 */
	public Person(int personId, String personName, String personMb, AdharInfo ad) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personMb = personMb;
		this.ad = ad;
	}
	
	public Person() {
		
	}
	
}

@Entity
@Table(name="adhar_INFO")
class AdharInfo {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="adhar_number") 
	  int adharNumber;
	 @Column(name = "address")
	  String address;
	public int getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(int adharNumber) {
		this.adharNumber = adharNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "AdharInfo [adharNumber=" + adharNumber + ", address=" + address + "]";
	}
	/**
	 * @param adharNumber
	 * @param address
	 */
	public AdharInfo(int adharNumber, String address) {
		super();
		this.adharNumber = adharNumber;
		this.address = address;
	}
	 
	public AdharInfo() {
		
	} 
	 
	
}
