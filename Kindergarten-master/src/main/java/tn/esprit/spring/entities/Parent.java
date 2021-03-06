package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.Length;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "file")
@Entity
public class Parent implements Serializable {
	
	
	private static final long serialVersionUID = -5303413519078617444L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idparent")
	private int idparent;
	@NotEmpty(message = "{error ==> fisrtnameEmpty}")
	@Length(min = 3, max = 20, message = "{error ==> firstnameSize}")
	private String firstname;
	@NotEmpty(message = "{error ==> lastnameEmpty}")
	@Length(min = 3, max = 20, message = "{error ==> lastnameSize}")
	private String lastname;
	private String address ;
	private int phone ;
	@Email
	@NotBlank
	@Size(max = 50)
	private String email;
	@NotBlank
	@Size(max = 20)
	private String login;
	@NotBlank
	@Size(min = 6, max = 8 )
	private String password ;
	//@Lob
    private String picture;
	/*
	@OneToOne()
	@JoinColumn(name="FK_PIC")
    private FileDB picture;


	@OneToMany(mappedBy="parent" )
	private List <Child> children ;

	@OneToMany(mappedBy="parent" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set <Post> posts ;
*/


	
	public Parent() {
		super();
	}

	public Parent(int idparent, String firstname, String lastname, String address, int phone, 
			String email, String login, String password) {
		super();
		this.idparent = idparent;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.login = login;
		this.password = password;
	}






	public Parent(
			@NotEmpty(message = "{error ==> fisrtnameEmpty}") @Length(min = 3, max = 20, message = "{error ==> firstnameSize}") String firstname,
			@NotEmpty(message = "{error ==> lastnameEmpty}") @Length(min = 3, max = 20, message = "{error ==> lastnameSize}") String lastname,
			String address, int phone, @Email @NotBlank @Size(max = 50) String email,
			@NotBlank @Size(max = 20) String login, @NotBlank @Size(min = 6, max = 8) String password ) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.login = login;
		this.password = password;
	   
	}
	

	

	public int getIdparent() {
		return idparent;
	}

	public void setIdparent(int idparent) {
		this.idparent = idparent;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	/*

	public List <Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}
	/*
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}


	public FileDB getPicture() {
		return picture;
	}

	public void setPicture(FileDB picture) {
		this.picture = picture;
	}

*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idparent;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + phone;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idparent != other.idparent)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (phone != other.phone)
			return false;
		return true;
	}

	

	

}
