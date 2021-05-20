package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Path")
public class Path implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4032913488251485502L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="IdPath")
	int id;
	@Column(name="Distance")
	float distance ;
	
	
	public Path() {}
	public float getDistance () {  return distance ;}
	public void setDistance(float d) {this.distance = d;}

	

	
	// la classe stop
	
	@Entity
	@Table(name="Stop")
	public class Stop implements Serializable {
	/**
		 * 
		 */
		private static final long serialVersionUID = 3172052450937581411L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="IdStop")
	int idStop;

	@Column(name="Adress")
	String adress;


	public String getAdress () {return adress ; } 
	public void setAdress(String a) {this.adress= a; }

	public Stop () {} 



	@OneToMany(mappedBy = "stop")
	private List <Affect> affects ;

	public List <Affect> getAffects() { 
		return affects ; 
	}
	public void setAffects (List<Affect> affects)
	{this.affects= affects ; }

	} 
}
