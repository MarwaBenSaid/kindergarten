package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@ManyToOne
	@JoinColumn(name="FK_PARENT_ID")
	Parent parent;
	@OneToMany(mappedBy="post" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set <Comment> comments ;
	
	
	public Post() {
		super();
	}
	
	
	public Post(int idpost, String content) {
		super();
		this.idpost = idpost;
		this.content = content;
	}


	public Post(int idpost, String content, Date datepost, int nblike, Parent parent, Set<Comment> comments) {
		super();
		this.idpost = idpost;
		this.content = content;
		this.datepost = datepost;
		this.nblike = nblike;
		this.parent = parent;
		this.comments = comments;
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


	public Parent getParent() {
		return parent;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public Set<Comment> getComments() {
		return comments;
	}


	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}


	public String getContent() {
		return content;
	}

}
