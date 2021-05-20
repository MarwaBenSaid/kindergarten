package tn.esprit.spring.entities;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Bus")
public class Bus implements Serializable {
private static final long serialVersionUID = 1L;	

@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
@Column(name="BusId")
 int busId ; 

@Column(name="NbrRegistration")
String nbrRegistration ; 

@Temporal(TemporalType.DATE)
@Column(name="CommissioningDate")
Date commissioningDate ;
@Column(name="NbrServiceYear")
int nbrServiceYear;
@Column(name="Capacity")
 int capacity;


public int getBusId() {return this.busId ; }
public void setBusIs ( int id ) { this.busId=id ; }
public String getNbrRegistration () {return this.nbrRegistration  ; } 
public void setNbrRegistration ( String nbr) {this.nbrRegistration = nbr; } 
public Date getCommissioningDate () {return commissioningDate ; } 
public void setCommissionigDate(Date c) {this.commissioningDate= c; }
public int getNbrServiceYear () {return nbrServiceYear ; } 
public void setNbrService(int n) {this.nbrServiceYear=n; }
public int getCapacity () {return capacity ; } 
public void setCapacity(int c) {this.capacity= c; }

public Bus () {} 

public Bus ( int id, String nbr , Date c , int service , int capacity)

{  this.busId=id ; 
  this.nbrRegistration = nbr ;
  this.commissioningDate = c; 
  this.nbrServiceYear=service ; 
  this.capacity = capacity ; 
		
	}


public String toString () {
return "   Nbr registration" + this.nbrRegistration + "      Commisioning date :" + this.commissioningDate + "      Nbr service year:" + this.nbrServiceYear + "     Capacity:" + this.capacity ;	
}

 
/*@OneToMany(mappedBy = "bus")
private List <Affect> affects ;
public List <Affect> getAffects() { 
	return affects ; 
}
public void setAffects (List<Affect> affects)
{this.affects= affects ; }

*/

}
