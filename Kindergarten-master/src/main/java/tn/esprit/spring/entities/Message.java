package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7194698577829498869L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Description;
	private Date creationDate;
	private Date lastUpdateDate;

	@ManyToOne
	private Parent Sender;

	@ManyToOne
	private Parent Reciever;

	public Message() {
	}

	@PrePersist
	protected void onCreate() {
		this.creationDate = new Date();
		this.lastUpdateDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.lastUpdateDate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Parent getSender() {
		return Sender;
	}

	public void setSender(Parent sender) {
		Sender = sender;
	}

	public Parent getReciever() {
		return Reciever;
	}

	public void setReciever(Parent reciever) {
		Reciever = reciever;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Message(int id, String description, Date creationDate, Date lastUpdateDate, Parent sender, Parent reciever) {
		super();
		this.id = id;
		Description = description;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
		Sender = sender;
		Reciever = reciever;
	}

	public Message(String description, Parent sender, Parent reciever) {
		super();
		Description = description;
		Sender = sender;
		Reciever = reciever;
	}
}