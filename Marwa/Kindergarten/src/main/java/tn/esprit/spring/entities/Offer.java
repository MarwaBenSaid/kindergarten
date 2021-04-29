package tn.esprit.spring.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Offer implements Serializable  {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOffer ;
	private static final long serialVersionUID = 4790500637390968870L;
	private String jobtitle;
	@Temporal(TemporalType.DATE)
	private Date datedebut;
	@Enumerated(EnumType.STRING)
    private Quality quality;
	private String jobdescription;
	private String functions;
	
	
	
	
	public Offer() {
		super();
	}
	public Offer(String jobtitle, Date datedebut, Quality quality, String jobdescription, String functions) {
		super();
		this.jobtitle = jobtitle;
		this.datedebut = datedebut;
		this.quality = quality;
		this.jobdescription = jobdescription;
		this.functions = functions;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Quality getQuality() {
		return quality;
	}
	public void setQuality(Quality quality) {
		this.quality = quality;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	public String getFunctions() {
		return functions;
	}
	public void setFunctions(String functions) {
		this.functions = functions;
	} 
	
	
	
	
	
	
}