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
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7194698577829498869L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmsg ;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date datemsg;
	@ManyToOne
	@JoinColumn(name="FK_PARENT_ID")
	Parent parent;
	
	public Message() {
		super();
	}
	public Message(int idmsg, String description, Date datemsg) {
		super();
		this.idmsg = idmsg;
		this.description = description;
		this.datemsg = datemsg;
	}
	public int getIdmsg() {
		return idmsg;
	}
	public void setIdmsg(int idmsg) {
		this.idmsg = idmsg;
	}
	public Date getDatemsg() {
		return datemsg;
	}
	public void setDatemsg(Date datemsg) {
		this.datemsg = datemsg;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
