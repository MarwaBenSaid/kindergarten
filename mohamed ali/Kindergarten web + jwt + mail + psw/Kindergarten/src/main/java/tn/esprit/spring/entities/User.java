package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;




@Entity
public class User  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2486;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idu;
	private String email;
	private String username ;
	private String password;
	private int telephone;
	private String role;
	private int zipCode;
	
	public User() {
		super();
	}

	

	



	public User(int idu, String email, String username, String password, int telephone, String role, int zipCode) {
		super();
		this.idu = idu;
		this.email = email;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.role = role;
		this.zipCode = zipCode;
	}







	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getIdu() {
		return idu;
	}

	public void setIdu(int idu) {
		this.idu = idu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public int getZipCode() {
		return zipCode;
	}







	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}







	

	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        User userTst = (User) o;
	        return idu == userTst.idu &&
	                telephone == userTst.telephone &&
	                Objects.equals(role, userTst.role) &&
	                Objects.equals(username, userTst.username) &&
	                Objects.equals(email, userTst.email) &&
	                Objects.equals(password, userTst.password);
	    }

	@Override
	public String toString() {
		return "User [idu=" + idu + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", telephone=" + telephone + ", role=" + role + "]";
	}
	
	
	
	

}
