package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Enfant  implements Serializable {
	
	
	private static final long serialVersionUID = 1050052179953534337L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private String picture ;
	@Temporal(TemporalType.DATE)
	private Date dateBirth;
   

	public Enfant() {
		super();
	}
	
	public Enfant(String firstname, String lastname, String picture, Date dateBirth) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.picture = picture;
		this.dateBirth = dateBirth;
	}

	
	


	public Enfant(int id, String firstname, String lastname,  String picture, Date dateBirth) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.picture = picture;
		this.dateBirth = dateBirth;
	}


	public String getFirstname() {
		return firstname;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Date getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

}
