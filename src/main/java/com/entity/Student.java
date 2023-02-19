package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "student_data")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="student")
public class Student {
         
	    @Id
	    @Column(name = "student_id")
	    int studentId;
	    
	    @Column(name = "student_name")
	    String studentName; 
	    
	    @Column(name = "mark")
	    int mark;
	    
	    @Column(name = "student_address")
	    String studentAddress; 
	    

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public int getMark() {
			return mark;
		}

		public void setMark(int mark) {
			this.mark = mark;
		}

		public Student(int studentId, String studentName, int mark) {
			super();
			this.studentId = studentId;
			this.studentName = studentName;
			this.mark = mark;
		}

		
	    
	    public String getStudentAddress() {
			return studentAddress;
		}

		public void setStudentAddress(String studentAddress) {
			this.studentAddress = studentAddress;
		}
		
		

		/**
		 * @param studentId
		 * @param studentName
		 * @param mark
		 * @param studentAddress
		 */
		public Student(int studentId, String studentName, int mark, String studentAddress) {
			super();
			this.studentId = studentId;
			this.studentName = studentName;
			this.mark = mark;
			this.studentAddress = studentAddress;
		}

		public Student() {
	    	
	    }

		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", studentName=" + studentName + ", mark=" + mark
					+ ", studentAddress=" + studentAddress + "]";
		}
		
		
}
