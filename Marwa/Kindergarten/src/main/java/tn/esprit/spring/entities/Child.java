package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Child  implements Serializable {
	
	
	private static final long serialVersionUID = 1050052179953534337L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idchild;
	private String firstname;
	private String lastname;
	private String picture ;
	@Temporal(TemporalType.DATE)
	private Date dateBirth;
	
	@ManyToOne
	@JoinColumn(name="FK_PARENT_ID")
	Parent parent;
	
	@ManyToOne
	@JoinColumn(name="FK_Kind_ID")
	Kindergarten kindergarten;
	
	public Child() {
		super();
	}
	
	public Child(String firstname, String lastname, String picture, Date dateBirth) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.picture = picture;
		this.dateBirth = dateBirth;
	}

	
	


	public Child(int idchild, String firstname, String lastname,  String picture, Date dateBirth) {
		super();
		this.idchild = idchild;
		this.firstname = firstname;
		this.lastname = lastname;
		this.picture = picture;
		this.dateBirth = dateBirth;
	}

	public int getIdchild() {
		return idchild;
	}
	public void setIdchild(int idchild) {
		this.idchild = idchild;
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
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	
	public Kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}
}
