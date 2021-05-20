package tn.esprit.spring.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AffectId implements java.io.Serializable {

   /**
	 * 
	 */
	private static final long serialVersionUID = -2537164944137642017L;
Driver driver ; 
   Bus bus ; 
	
    @ManyToOne
    public Driver getDriver () {
 	   return driver ; 
    }
    
    @ManyToOne
    public Bus getBus () {
    	return bus ; 
    }
    
    
    
    
  

   public void setDriver (Driver d) { 
	this.driver = d ;  
   }

   public void setBus (Bus b)
   {this.bus=b;}
    }





