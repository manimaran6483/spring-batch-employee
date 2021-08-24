package com.batch.example.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Employee {

	@Id
	private Integer id;
	private String fullname;
	private String gender;
	private String email;
	private String fathername;
	private String mothername;
	private String phnno;
	private String address;
	private Date timestamp;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getPhnno() {
		return phnno;
	}
	public void setPhnno(String phnno) {
		this.phnno = phnno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullname=" + fullname + ", gender=" + gender + ", email=" + email
				+ ", fathername=" + fathername + ", mothername=" + mothername + ", phnno=" + phnno + ", address="
				+ address + ", timestamp=" + timestamp + "]";
	}
	public Employee(Integer id, String fullname, String gender, String email, String fathername, String mothername,
			String phnno, String address, Date timestamp) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.gender = gender;
		this.email = email;
		this.fathername = fathername;
		this.mothername = mothername;
		this.phnno = phnno;
		this.address = address;
		this.timestamp = timestamp;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}