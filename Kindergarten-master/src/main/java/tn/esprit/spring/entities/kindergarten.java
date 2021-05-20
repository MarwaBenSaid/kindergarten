package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import tn.esprit.spring.aspect.loggable;







@Entity
public class kindergarten  implements Serializable {
	
	private static final long serialVersionUID = 1050052174953534337L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkindergarten;
	@NotBlank 
	private String name;
	@NotBlank 

	private String description;
	@NotBlank 
	@Email
	private String email ;
	
	
	private String nbremployee ;
	
	
	
	@OneToMany(mappedBy="kindergarten")
	private Set<Activity> activity;


	private float cost ;
	
	@OneToMany(mappedBy="kindergarten")
	private Set<Child> children;
	

	@OneToOne
	private Parent userkinder;

	@ManyToMany
	private List<Parent> user;

	
	
	
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


















	public kindergarten() {
		super();
	}




	




	




	



	public kindergarten(int idkindergarten, @NotBlank String name) {
		super();
		this.idkindergarten = idkindergarten;
		this.name = name;
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
	@loggable 
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

	
	public String getNbremployee() {
		return nbremployee;
	}

	public void setNbremployee(String nbremployee) {
		this.nbremployee = nbremployee;
	}

	

	

	public Set<Activity> getActivity() {
		return activity;
	}




	public void setActivity(Set<Activity> activity) {
		this.activity = activity;
	}




	

	public void throwException(){
		throw new RuntimeException("Dummy Exception");
	}


















	public void getIdkindergarten(int id) {
		// TODO Auto-generated method stub
		
	}	

	
	
	

}
