package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity

public class Appointment  implements Serializable{
	private static final long serialVersionUID = 1050052174953534337L;
	
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id", updatable = false)
     private int  id;
	 @Temporal(TemporalType.DATE)
	    @JsonFormat(pattern="yyyy-MM-dd")
     private Date date;
     
     @Enumerated(EnumType.STRING)
     private shifts shift;
	 @OneToOne
	    public kindergarten kindergarten;
	 @OneToOne 
	    public Parent parent;
	public Appointment() {
		super();
	}
	
	
	
	public Appointment(Date date, Parent parent, tn.esprit.spring.entities.kindergarten kindergarten, shifts shift) {
		super();
		this.date = date;
		this.parent = parent;
		this.kindergarten = kindergarten;
		this.shift = shift;
	}



	public Appointment(int id, Date date, shifts shift, tn.esprit.spring.entities.kindergarten kindergarten,
			Parent parent) {
		super();
		this.id = id;
		this.date = date;
		this.shift = shift;
		this.kindergarten = kindergarten;
		this.parent = parent;
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
	public shifts getShift() {
		return shift;
	}
	public void setShift(shifts shift) {
		this.shift = shift;
	}
	public kindergarten getKindergarten() {
		return kindergarten;
	}
	public void setKindergarten(kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	
}    
    
    
	

