package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class Student {
         
	    @Id
	    @Column(name = "student_id")
	    int studentId;
	    
	    @Column(name = "student_name")
	    String studentName; 
	    
	    @Column(name = "mark")
	    int mark;

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

		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", studentName=" + studentName + ", mark=" + mark + "]";
		}
	    
	    public Student() {
	    	
	    }
}
