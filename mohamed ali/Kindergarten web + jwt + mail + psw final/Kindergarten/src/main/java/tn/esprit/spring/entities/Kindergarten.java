package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kindergarten  implements Serializable{
	
	private static final long serialVersionUID = 1050052174953534337L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkindergarten;
	private String name;
	private String description;
	private String email ;
	private String logo ;
	private String nbremployee ;
	
	@OneToMany(mappedBy="kindergarten")
	private Set<Reclamation> reclamation;
	

	public Kindergarten() {
		super();
	}


	public Kindergarten(int idkindergarten, String name, String description, String email, String logo,
			String nbremployee) {
		super();
		this.idkindergarten = idkindergarten;
		this.name = name;
		this.description = description;
		this.email = email;
		this.logo = logo;
		this.nbremployee = nbremployee;
	}

	


	



	public Kindergarten(int idkindergarten, String name, String description, String email, String logo,
			String nbremployee, Set<Reclamation> reclamation) {
		super();
		this.idkindergarten = idkindergarten;
		this.name = name;
		this.description = description;
		this.email = email;
		this.logo = logo;
		this.nbremployee = nbremployee;
		this.reclamation = reclamation;
	}


	public int getIdkindergarten() {
		return idkindergarten;
	}



	public void setIdkindergarten(int idkindergarten) {
		this.idkindergarten = idkindergarten;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getLogo() {
		return logo;
	}



	public void setLogo(String logo) {
		this.logo = logo;
	}



	public String getNbremployee() {
		return nbremployee;
	}



	public void setNbremployee(String nbremployee) {
		this.nbremployee = nbremployee;
	}


	public Set<Reclamation> getReclamation() {
		return reclamation;
	}


	public void setReclamation(Set<Reclamation> reclamation) {
		this.reclamation = reclamation;
	}



	



	


	

	
	
	
}
