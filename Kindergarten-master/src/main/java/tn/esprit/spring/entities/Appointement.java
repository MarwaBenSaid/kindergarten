package tn.esprit.spring.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Appointement implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")

	private Date date;
	@OneToOne
	private Parent Parent;
	@OneToOne
	private kindergarten kindergarten;
	@Enumerated(EnumType.STRING)
	private shifts shift;
	public Appointement() {
		super();
	}
	
	public Appointement(Date key, tn.esprit.spring.entities.Parent tmpParent,
			tn.esprit.spring.entities.kindergarten tmpkindergarten, shifts shifts) {
		// TODO Auto-generated constructor stub
	}

	public Appointement(int id, Date date, shifts shift) {
		super();
		this.id = id;
		this.date = date;
		this.shift = shift;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Parent getParent() {
		return Parent;
	}
	public void setParent(Parent parent) {
		Parent = parent;
	}
	public kindergarten getKindergarten() {
		return kindergarten;
	}
	public void setKindergarten(kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}
	public shifts getShift() {
		return shift;
	}
	public void setShift(shifts shift) {
		this.shift = shift;
	}
	
}