package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Post implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3016798745017433910L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpost;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date datepost;
	private int nblike ;
	
	
	
	public Post() {
		super();
	}
	
	
	public Post(int idpost, String content) {
		super();
		this.idpost = idpost;
		this.content = content;
	}


	public Post(int idpost, String content, Date datepost, int nblike) {
		super();
		this.idpost = idpost;
		this.content = content;
		this.datepost = datepost;
		this.nblike = nblike;
		
	}


	public int getIdpost() {
		return idpost;
	}
	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}
	public String getContenu() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	public Date getDatepost() {
		return datepost;
	}


	public void setDatepost(Date datepost) {
		this.datepost = datepost;
	}


	public int getNblike() {
		return nblike;
	}


	public void setNblike(int nblike) {
		this.nblike = nblike;
	}




	public String getContent() {
		return content;
	}

}
