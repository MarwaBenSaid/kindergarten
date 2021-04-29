package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5981557505349268959L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idcandiate; 
	private String firstname;
	private String lastname;
	private String address ;
	private int phone ;
	private int age;
	private String picture ;
	private String email;
	private String login;
	private String password;
	private String description; 
	private String cv; 
	private String job;
	
	
	
	public Candidate(int idcandiate, String firstname, String lastname, String address, int phone, int age,
			String picture, String email, String login, String password, String description, String cv, String job) {
		super();
		this.idcandiate = idcandiate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.age = age;
		this.picture = picture;
		this.email = email;
		this.login = login;
		this.password = password;
		this.description = description;
		this.cv = cv;
		this.job = job;
	}
	public Candidate() {
		super();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getIdcandiate() {
		return idcandiate;
	}
	public void setIdcandiate(int idcandiate) {
		this.idcandiate = idcandiate;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	} 
	
	
	
}
