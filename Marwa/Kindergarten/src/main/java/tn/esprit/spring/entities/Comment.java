package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5016040223922828268L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcomment ;
	private String contentCom ;
	@Temporal(TemporalType.DATE)
	private Date datecomment;
	
	@ManyToOne
	@JoinColumn(name="FK_POST_ID")
	Post post;
	
	public Comment(int idcomment, String contentCom, Date datecomment) {
		super();
		this.idcomment = idcomment;
		this.contentCom = contentCom;
		this.datecomment = datecomment;
	}
	public int getIdcomment() {
		return idcomment;
	}
	public void setIdcomment(int idcomment) {
		this.idcomment = idcomment;
	}
	public String getContentCom() {
		return contentCom;
	}
	public void setContentCom(String contentCom) {
		this.contentCom = contentCom;
	}
	public Date getDatecomment() {
		return datecomment;
	}
	public void setDatecomment(Date datecomment) {
		this.datecomment = datecomment;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}

	
}
