package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Admin implements Serializable {
	
	private static final long serialVersionUID = 2486;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idadmin ;
	private String nameadmin ;
	private int phoneadmin ;
	private String pictureadmin ;
	@NotBlank
	@Size(max = 50)
	@Email
	private String emailadmin;
	@NotBlank
	@Size(max = 8 )
	private String passwordadmin ;
	
	
	public Admin() {
		super();
	}


	public Admin(int idadmin, String nameadmin, int phoneadmin, String pictureadmin,
			@NotBlank @Size(max = 50) @Email String emailadmin, @NotBlank @Size(max = 8) String passwordadmin) {
		super();
		this.idadmin = idadmin;
		this.nameadmin = nameadmin;
		this.phoneadmin = phoneadmin;
		this.pictureadmin = pictureadmin;
		this.emailadmin = emailadmin;
		this.passwordadmin = passwordadmin;
	}


	public Admin(int idadmin, String nameadmin, int phoneadmin, @NotBlank @Size(max = 50) @Email String emailadmin,
			@NotBlank @Size(max = 8) String passwordadmin) {
		super();
		this.idadmin = idadmin;
		this.nameadmin = nameadmin;
		this.phoneadmin = phoneadmin;
		this.emailadmin = emailadmin;
		this.passwordadmin = passwordadmin;
	}


	public int getIdadmin() {
		return idadmin;
	}


	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}


	public String getNameadmin() {
		return nameadmin;
	}


	public void setNameadmin(String nameadmin) {
		this.nameadmin = nameadmin;
	}


	public int getPhoneadmin() {
		return phoneadmin;
	}


	public void setPhoneadmin(int phoneadmin) {
		this.phoneadmin = phoneadmin;
	}


	public String getPictureadmin() {
		return pictureadmin;
	}


	public void setPictureadmin(String pictureadmin) {
		this.pictureadmin = pictureadmin;
	}


	public String getEmailadmin() {
		return emailadmin;
	}


	public void setEmailadmin(String emailadmin) {
		this.emailadmin = emailadmin;
	}


	public String getPasswordadmin() {
		return passwordadmin;
	}


	public void setPasswordadmin(String passwordadmin) {
		this.passwordadmin = passwordadmin;
	}
	
	
	

}
