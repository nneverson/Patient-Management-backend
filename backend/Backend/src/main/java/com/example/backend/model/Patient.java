package com.example.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String diagnosis;
	private String address;
	private String phoneNumber;
	private String mdName;
	
public Patient() {
	
}
public Patient(int id, String firstName,String lastName, String diagnosis, String address, String phoneNumber, String mdName) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.diagnosis = diagnosis;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.mdName = mdName;
	
}
public int getId() {
	return id;
}

public String getFirstName() {
	return firstName;
}
public String getLastName() {
	return lastName;
}
public String getDiagnosis() {
	return diagnosis;
}

public String getAddress() {
	return address;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public String getMdName() {
	return mdName;
}




public void setId(int id) {
	this.id= id;
}
public void setFirstName(String firstName) {
	this.firstName =firstName;
}
public void setLastName(String lastName) {
	this.lastName =lastName;
}
public void setDiagnosis(String diagnosis) {
	this.diagnosis = diagnosis;
}
public void setAddress( String address) {
	this.address= address;
}
public void setPhoneNumber( String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public void setMdName(String mdName) {
	this.mdName = mdName;
}

//@Override
//public String toString() {
//	return "Patient [id=" + id + "name=" + name + "diagnosis =" + diagnosis + "address=" + address + "phone number=" + phoneNumber+ " md Name=" + mdName+ "]";
//}


}

