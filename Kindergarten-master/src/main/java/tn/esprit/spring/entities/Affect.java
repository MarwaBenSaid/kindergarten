package tn.esprit.spring.entities;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity

public class Affect implements java.io.Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -8397887844856232042L;
     Driver driver ; 
	 Bus bus ; 
	Stop stop ; 
	Child child ; 
	 kindergarten kindergarten ; 

	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)

	 int idAffect; 
	public int getIdAffect () {return this.idAffect ; }
	
	
    @Temporal(TemporalType.DATE)
    @Column(name="Date")
    public Date date ;
    public Date getDate () { return date;} 
    public void setDate ( Date d) {this.date= d ;}
    
    
   // @Temporal(TemporalType.TIME)
   // @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    //@DateTimeFormat(style = "h:mm a")
   // @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
    @Column(name="DepartureTime")
    private String departureTime ; 
    public String getDepartureTime () { return departureTime ; } 
    public void setDepartureTime (String dt) {this.departureTime = dt ;}
    
    
    
   // @Temporal(TemporalType.TIME)
    @Column(name="ArrivalTime")
    private String arrivalTime ; 
    public String getArrivalTime() {return arrivalTime;} 
    public void setArrivalTime ( String da) { this.arrivalTime= da;} 
    
    
   
  
    @ManyToOne 
    @JoinColumn (name ="FK_IdDriver")
    public int getDriver() { return driver.getDriverId(); } 
    public void setDriver ( int d ) { this.driver.setDriverId(d); } 
    
    
    
    
    @ManyToOne 
    @JoinColumn (name ="NbrRegistration" )
    public Bus getBus() { return bus; } 
    public void setBus ( Bus b ) { this.bus = b ; } 
    
    
    @ManyToOne 
    @JoinColumn (name ="Fk_IdStop")
    
    public Stop getStop() { return stop ; } 
    public void setStop (Stop s  ) { this.stop = s ; } 
    
    
    @ManyToOne 
    @JoinColumn (name ="FK_idchild")
    public int getChild () { return child.getIdchild() ; } 
    public void setChild (int c ) { this.child.setIdchild(c); } 
    
    
    @ManyToOne 
    @JoinColumn (name ="FK_idkindergarten" )
    public kindergarten getKindergarten () { return kindergarten ; } 
    public void setKindergarten (kindergarten k  ) { this.kindergarten = k ; } 
    
    
    
    
    
}
