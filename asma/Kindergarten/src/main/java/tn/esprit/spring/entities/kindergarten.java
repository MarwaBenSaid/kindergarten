package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class kindergarten  implements Serializable {
	
	private static final long serialVersionUID = 1050052174953534337L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkindergarten;
	private String name;
	private String description;
	private String email ;
	private String logo ;
	@Temporal(TemporalType.DATE)
	private Date date;
	private int nbremployee ;
	private float cost ;
	@OneToMany(mappedBy="kindergarten")
	@JsonIgnore
	private Set<Offer> offer;
	//@OneToMany(mappedBy="kindergarten")
	//private Set<Appointment> appointment;
	@OneToMany(mappedBy="kindergarten")
	@JsonIgnore
	private Set<Candidate> employees;
	
	
	
	public Set<Candidate> getEmployees() {
		return employees;
	}




	public void setEmployees(Set<Candidate> employees) {
		this.employees = employees;
	}




	public kindergarten() {
		super();
	}




	public kindergarten(int idkindergarten, String name) {
		super();
		this.idkindergarten = idkindergarten;
		this.name = name;
	}




	public kindergarten(int idkindergarten, String name, String description, String email, String logo, Date date,
			int nbremployee, float cost) {
		super();
		this.idkindergarten = idkindergarten;
		this.name = name;
		this.description = description;
		this.email = email;
		this.logo = logo;
		this.date = date;
		this.nbremployee = nbremployee;
		this.cost = cost;
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

	public int getNbremployee() {
		return nbremployee;
	}

	public void setNbremployee(int nbremployee) {
		this.nbremployee = nbremployee;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}




	public Set<Offer> getOffer() {
		return offer;
	}




	public void setOffer(Set<Offer> offer) {
		this.offer = offer;
	}
	




	/*public Set<Appointment> getAppointment() {
		return appointment;
	}




	public void setAppointment(Set<Appointment> appointment) {
		this.appointment = appointment;
	}*/




	
	
	

}
