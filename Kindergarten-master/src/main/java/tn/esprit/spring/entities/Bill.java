package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBill;
	
	private String Description;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date DateOfBill;
	private float TotalPrice;
    @Transient
   private String  usnm ;
	@ManyToOne
	private Parent parent;
	@Transient
	private String  kindername ;

	
	@ManyToOne
	private kindergarten kindergarten;
	
	public Bill () {}
	
	

	public Bill(int idBill, String description, Date dateOfBill, float totalPrice, String usnm, Parent parent,
			String kindername, kindergarten kindergarten) {
		super();
		this.idBill = idBill;
		Description = description;
		DateOfBill = dateOfBill;
		TotalPrice = totalPrice;
		this.usnm = usnm;
		this.parent = parent;
		this.kindername = kindername;
		this.kindergarten = kindergarten;
	}

	
	


	public Bill(String description, Date dateOfBill, float totalPrice, String usnm, Parent parent,
			kindergarten kindergarten) {
		super();
		Description = description;
		DateOfBill = dateOfBill;
		TotalPrice = totalPrice;
		this.usnm = usnm;
		this.parent = parent;
		this.kindergarten = kindergarten;
	}



	public String getKindername() {
		return kindername;
	}


	public void setKindername(String kindername) {
		this.kindername = kindername;
	}


	public int getIdBill() {
		return idBill;
	}

	public String getUsnm() {
		return usnm;
	}

	public void setUsnm(String usnm) {
		this.usnm = usnm;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getDateOfBill() {
		return DateOfBill;
	}

	public void setDateOfBill(Date dateOfBill) {
		DateOfBill = dateOfBill;
	}

	public float getTotalPrice() {
		return TotalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		TotalPrice = totalPrice;
	}



	public Parent getParent() {
		return parent;
	}


	public void setParent(Parent parent) {
		this.parent =parent;
	}


	public kindergarten getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}

	public Bill(String description, Date dateOfBill, float totalPrice) {
		super();
		Description = description;
		DateOfBill = dateOfBill;
		TotalPrice = totalPrice;
	}


}
