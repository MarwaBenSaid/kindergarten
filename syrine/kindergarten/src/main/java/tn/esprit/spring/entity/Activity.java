package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Activity  implements Serializable {
	 
	private static final long serialVersionUID = 1050052174953534337L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idActivity;
	@Temporal(TemporalType.DATE)
	private Date dateA;
	private String description ;
	@ManyToOne
	@JoinColumn(name="FK_TP_ID")
	kindergarten kindergarten;

	
	@OneToOne()
	@JoinColumn(name="FK_TPA_ID")
    private FileDB filedb;
	public Activity() {
		super();
	}

	

	public Activity(int idActivity, String description) {
		super();
		this.idActivity = idActivity;
		this.description = description;
	}



	

	public Activity(int idActivity, Date dateA, String description) {
		super();
		this.idActivity = idActivity;
		this.dateA = dateA;
		this.description = description;
	}



	public int getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}

	public Date getDateA() {
		return dateA;
	}

	public void setDateA(Date dateA) {
		this.dateA = dateA;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}





	public kindergarten getKindergarten() {
		return kindergarten;
	}



	public void setKindergarten(kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}



	public FileDB getFiledb() {
		return filedb;
	}



	public void setFiledb(FileDB filedb) {
		this.filedb = filedb;
	}

	
	
}
