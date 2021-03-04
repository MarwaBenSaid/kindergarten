package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String picture ;

	//@ManyToOne
	 //@JoinColumn(name="FK_KINDERGARTEN_ID")
	 
	//kindergarten //kindergartens;

	
	public Activity() {
		super();
	}

	

	public Activity(int idActivity, String description) {
		super();
		this.idActivity = idActivity;
		this.description = description;
	}



	public Activity(int idActivity, Date dateA, String description, String picture) {
		super();
		this.idActivity = idActivity;
		this.dateA = dateA;
		this.description = description;
		this.picture = picture;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	//public kindergarten getKindergartens() {
		//return kindergartens;
	//}

	//public void setKindergartens(kindergarten kindergartens) {
		//this.kindergartens = kindergartens;
	//}
	
}
