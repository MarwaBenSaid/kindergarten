package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	@Entity
	@Table(name="TransportManager")
	public class TransportManager implements Serializable {
	/**
		 * 
		 */
		private static final long serialVersionUID = 888888955;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	
	int idManger;
	@Column(name="FirstName")
	String firstName;
	@Column(name="LastName")
	String lastName;
	@Column(name="Phone")
	String phone ;
	@Column(name="Email")
	String email ;
	@Column(name="Cin")
	String cin ;
	@Column(name="Photo")
	String photo ;
	@Column(name="Adress")
	String adress ;
	public TransportManager() {}
	public String getFirtName () {  return firstName ;}
	public void setFirstName(String fn) {this.firstName = fn;}
	public String getLastName () {  return lastName ;}
	public void setLastName(String ln) {this.lastName = ln;}
	public String getPhone () {  return phone ;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getEmail () {  return email ;}
	public void setEmail(String email) {this.email = email;}
	public String getCin () {  return cin ;}
	public void setCin(String cin) {this.cin = cin;}
	public String getPhoto() {  return photo ;}
	public void setPhoto(String ph) {this.photo= ph;}
	public String getAdress () {  return adress ;}
	public void setAdress(String ad) {this.adress = ad;}
	
	//
	@OneToMany(mappedBy="transportManager")
	List <Driver> drivers; 
	
	
	
	}
	

