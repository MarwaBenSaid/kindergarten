package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany ;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;






	@Entity

	public class Driver implements Serializable {
	/**
		 * 
		 */
		private static final long serialVersionUID = 1236548;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	
	int idDriver;
	
	@Size(min = 2 , max= 16 , message =" the name must contain a minimum of 2 letters and a maximum of 16 letters")
	@NotNull 
	@Column(name="FirstName")
	String firstName;
	
	
	@Size(min = 2 , max= 16 , message =" the last name must contain a minimum of 2 letters and a maximum of 16 letters")
	@NotNull
	@Column(name="LastName")
	String lastName;
	
	@NotBlank
	@Column(name="Phone")
	String phone ;
	
	@NotBlank 
	@Column(name="Email")
    @Email(message="Check your email") 
	String email ;
	
	
	@Column(name="Cin")
	String cin ;
	
	
	
	@Column(name="Photo")
	String photo ;
	
	
	@Column(name="Adress")
	String adress ;
	
	
	@Column(name="Disponibility")
	Boolean disponibility;
	
	
	@Positive(message="the number of absences must be positive" )
	@Column(name="NbrAbscence")
	int nbrAbscence ;
	
	
	public Driver() {}
	public int getDriverId () { return this.idDriver ; } 
	public void setDriverId ( int id)  { this.idDriver=id; }
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
	public Boolean getDisponibility () {  return disponibility ;}
	public void setDisponibility(Boolean d) {this.disponibility = d;}
	public int getNbrAbscence () {  return nbrAbscence;}
	public void setNbrAbscence(int ab) {this.nbrAbscence = ab;}

	
	@ManyToOne
	@JoinColumn(name="transportManagerFK")
	TransportManager transportManager ; 
	
	
	
	@OneToMany(mappedBy = "driver")
	private List <Affect> affects ;

	public List <Affect> getAffects() { 
		return affects ; 
	}
	public void setAffects (List<Affect> affects)
	{this.affects= affects ; }
	
	
	
	@Override
	public String toString() {
		return String.format("Driver[id=%d, firstName='%s', Phone='%s']", idDriver, firstName, phone);
	}
	
	
	
	}
	

 