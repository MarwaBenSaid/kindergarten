package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


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
	private String email;
	private String login;
	private String password;
	private String description; 
	private String job;
	@OneToOne()
	@JoinColumn(name="FK_TPA_ID")
    private FileDB filedb;
	
	public Candidate() {
		super();
	}
	

	public Candidate(int idcandiate, String firstname, String lastname, String address, int phone, int age,
			String email, String login, String password, String description, String job) {
		super();
		this.idcandiate = idcandiate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.age = age;
		this.email = email;
		this.login = login;
		this.password = password;
		this.description = description;
		this.job = job;
	}


	public Candidate(int idcandiate, String firstname) {
		super();
		this.idcandiate = idcandiate;
		this.firstname = firstname;
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

	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}


	public FileDB getFiledb() {
		return filedb;
	}


	public void setFiledb(FileDB filedb) {
		this.filedb = filedb;
	}


	
	
	
}
