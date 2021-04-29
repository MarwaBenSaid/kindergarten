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
public class Offer implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4790500637390968870L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idoffer ;
	private String jobtitle;
	@Temporal(TemporalType.DATE)
	private Date datedebut;
    private String quality;
	private String jobdescription;
	private String functions;
	@ManyToOne
	@JoinColumn(name="FK_TP_ID")
	kindergarten kindergarten;
	
	
	public Offer() {
		super();
	}
	public Offer(int idoffer, String jobtitle, Date datedebut, String quality, String jobdescription,
			String functions) {
		super();
		this.idoffer = idoffer;
		this.jobtitle = jobtitle;
		this.datedebut = datedebut;
		this.quality = quality;
		this.jobdescription = jobdescription;
		this.functions = functions;
	}
	public int getIdoffer() {
		return idoffer;
	}
	public void setIdoffer(int idoffer) {
		this.idoffer = idoffer;
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
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public kindergarten getKindergarten() {
		return kindergarten;
	}
	public void setKindergarten(kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}


	
	
	
	
	
	
	
	
	
}
