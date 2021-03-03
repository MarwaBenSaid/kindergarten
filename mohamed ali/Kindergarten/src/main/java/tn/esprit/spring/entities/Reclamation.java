package tn.esprit.spring.entities;
import javax.persistence.Entity;
import javax.persistence.Id;


import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity

public class Reclamation implements Serializable {
	private static final long serialVersionUID = 2486;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idreclamation ;
	private String titre ;
	private String description ;
	@Temporal(TemporalType.DATE)
	private Date datereclamation ;
	private int nbreclamation ;
	
	
	
	public Reclamation(int idreclamation, String titre, String description, Date datereclamation, int nbreclamation) {
		super();
		this.idreclamation = idreclamation;
		this.titre = titre;
		this.description = description;
		this.datereclamation = datereclamation;
		this.nbreclamation = nbreclamation;
		
	}
	public Reclamation() {
		super();
	}
	
	public int getIdreclamation() {
		return idreclamation;
	}
	public void setIdreclamation(int idreclamation) {
		this.idreclamation = idreclamation;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDatereclamation() {
		return datereclamation;
	}
	public void setDatereclamation(Date datereclamation) {
		this.datereclamation = datereclamation;
	}
	public int getNbreclamation() {
		return nbreclamation;
	}
	public void setNbreclamation(int nbreclamation) {
		this.nbreclamation = nbreclamation;
	}
	
	
	
	
	

}
 