package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Kindergarten implements Serializable  {

	private static final long serialVersionUID = -7794285024324017561L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idkindergarten")
	private int idkindergarten ;
	private String name;
	private String description;
	private String email ;
	private String logo ;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String nbremployee ;
	private float cost ;
	@OneToMany(mappedBy="kindergarten")
	private Set<Child> children;
	

	@OneToOne
	private Parent userkinder;

	@ManyToMany
	private List<Parent> user;
	
	
	public Kindergarten() {
		super();
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNbremployee() {
		return nbremployee;
	}
	public void setNbremployee(String nbremployee) {
		this.nbremployee = nbremployee;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Set<Child> getChildren() {
		return children;
	}
	public void setChildren(Set<Child> children) {
		this.children = children;
	}
	public Parent getUserkinder() {
		return userkinder;
	}
	public void setUserkinder(Parent userkinder) {
		this.userkinder = userkinder;
	}
	public List<Parent> getUser() {
		return user;
	}
	public void setUser(List<Parent> user) {
		this.user = user;
	}
	
	
	
}
