package tn.esprit.spring.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Verification_Code {
	   @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	
	@OneToOne
	@JoinColumn(name = "user_idu", referencedColumnName = "idu")
	private User user_idu;
	public void setUser_id(User user_idu) {
		this.user_idu = user_idu; 
	}
	public Verification_Code() {
		super(); 
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User getUser_idu() {
		return user_idu;
	}
	public void setUser_idu(User user_idu) {
		this.user_idu = user_idu;
	}
	
	
	
	
}
