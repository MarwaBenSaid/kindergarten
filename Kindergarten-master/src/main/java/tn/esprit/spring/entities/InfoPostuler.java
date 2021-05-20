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
public class InfoPostuler implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numpost;
	@Temporal(TemporalType.DATE)
    private Date datepost;
	@ManyToOne
	private Offer offer;
	@ManyToOne
	private Candidate candidate;
	
	public InfoPostuler() {
		super();
	}
	public InfoPostuler(int numpost, Date datepost, Offer offer, Candidate candidate) {
		super();
		this.numpost = numpost;
		this.datepost = datepost;
		this.offer = offer;
		this.candidate = candidate;
	}
	public int getNumpost() {
		return numpost;
	}
	public void setNumpost(int numpost) {
		this.numpost = numpost;
	}
	public Date getDatepost() {
		return datepost;
	}
	public void setDatepost(Date datepost) {
		this.datepost = datepost;
	}
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
}
