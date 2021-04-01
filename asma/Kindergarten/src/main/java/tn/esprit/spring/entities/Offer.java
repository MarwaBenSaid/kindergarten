package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Temporal(TemporalType.DATE)
	private Date datefin;
    private String quality;
	private String jobdescription;
	private String functions;
	@ManyToOne
	@JoinColumn(name="FK_TP_ID")
	kindergarten kindergarten;
	@OneToMany(mappedBy="offer")
	private Set<InfoPostuler> infopostulers;
	
	

	public Offer() {
		super();
	}

	public Offer(int idoffer, String jobtitle, Date datedebut, Date datefin, String quality, String jobdescription,
			String functions, tn.esprit.spring.entities.kindergarten kindergarten, Set<InfoPostuler> infopostulers) {
		super();
		this.idoffer = idoffer;
		this.jobtitle = jobtitle;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.quality = quality;
		this.jobdescription = jobdescription;
		this.functions = functions;
		this.kindergarten = kindergarten;
		this.infopostulers = infopostulers;
	}

	public Set<InfoPostuler> getInfopostulers() {
		return infopostulers;
	}

	public void setInfopostulers(Set<InfoPostuler> infopostulers) {
		this.infopostulers = infopostulers;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
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
