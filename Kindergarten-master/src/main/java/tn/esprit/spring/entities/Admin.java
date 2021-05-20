package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "file")
@Component
@Entity
public class Admin implements Serializable {
	
	private static final long serialVersionUID = 2486;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idadmin ;
	private String nameadmin ;
	@NotNull(message= "phone  may not be empty")
	private Integer phoneadmin ;
	@NotBlank
	@Size(max = 50)
	@Email
	private String emailadmin;
	
	
	
	
	@OneToOne()
	@JoinColumn(name="FK_PIC")
    private FileDB filedb;

	

	public Admin() {
		super();
	}

	public Admin(int idadmin, String nameadmin, @NotNull(message = "phone  may not be empty") Integer phoneadmin,
			@NotBlank @Size(max = 50) @Email String emailadmin) {
		super();
		this.idadmin = idadmin;
		this.nameadmin = nameadmin;
		this.phoneadmin = phoneadmin;
		this.emailadmin = emailadmin;
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


	


	public String getEmailadmin() {
		return emailadmin;
	}


	public void setEmailadmin(String emailadmin) {
		this.emailadmin = emailadmin;
	}


	





	public FileDB getFiledb() {
		return filedb;
	}





	public void setFiledb(FileDB filedb) {
		this.filedb = filedb;
	}





	public void setPhoneadmin(Integer phoneadmin) {
		this.phoneadmin = phoneadmin;
	}


	


	


	
	
	
	

}
