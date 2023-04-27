package com.entity;

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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "office_info")
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "office_id") 
	 int officeId;
	
	@Column(name = "address")
	 String address;
	
	@Column(name = "pincode")
	String pincode;

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@LazyCollection(value = LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "OFFICE_ID")
	List<Employee>  lstEmp;

	public List<Employee> getLstEmp() {
		return lstEmp;
	}

	public void setLstEmp(List<Employee> lstEmp) {
		this.lstEmp = lstEmp;
	}

	@Override
	public String toString() {
		return "Office [officeId=" + officeId + ", address=" + address + ", pincode=" + pincode + ", lstEmp=" + lstEmp
				+ "]";
	}

	public Office(int officeId, String address, String pincode, List<Employee> lstEmp) {
		super();
		this.officeId = officeId;
		this.address = address;
		this.pincode = pincode;
		this.lstEmp = lstEmp;
	}
	
	
	public Office () {
		
	}
	
	
	
	
}
