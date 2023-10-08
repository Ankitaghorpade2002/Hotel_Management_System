package com.staffservice.Staff_Management_Service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StaffDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int SrNo;
	private String code;
	private String emp_name;
	private String emp_address;
	private String nic;
	private double salary;
	private int age;
	private String occupation;
	private String e_mail;
	
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getEmp_name() {
		return emp_name;
	}


	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}


	public String getEmp_address() {
		return emp_address;
	}


	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public String getE_mail() {
		return e_mail;
	}


	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}


	public StaffDetails(String code, String emp_name, String emp_address, String nic, double salary, int age,
			String occupation, String e_mail) {
		super();
		this.code = code;
		this.emp_name = emp_name;
		this.emp_address = emp_address;
		this.nic = nic;
		this.salary = salary;
		this.age = age;
		this.occupation = occupation;
		this.e_mail = e_mail;
	}


	public StaffDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
