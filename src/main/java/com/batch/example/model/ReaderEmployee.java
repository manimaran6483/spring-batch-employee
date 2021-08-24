package com.batch.example.model;

public class ReaderEmployee {
	private Integer empid;
	private String fname;
	private String lname;
	private String Gender;
	private String email;
	private String fathername;
	private String mothername;
	private String phnno;
	private String city;
	private String state;
	private String zip;
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "ReaderEmployee [empid=" + empid + ", fname=" + fname + ", lname=" + lname + ", Gender=" + Gender
				+ ", email=" + email + ", fathername=" + fathername + ", mothername=" + mothername + ", phnno=" + phnno
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
	public ReaderEmployee(Integer empid, String fname, String lname, String gender, String email, String fathername,
			String mothername, String phnno, String city, String state, String zip) {
		super();
		this.empid = empid;
		this.fname = fname;
		this.lname = lname;
		Gender = gender;
		this.email = email;
		this.fathername = fathername;
		this.mothername = mothername;
		this.phnno = phnno;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public ReaderEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}