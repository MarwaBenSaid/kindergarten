package tn.esprit.spring.entities;
import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity

public class Stop implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -5250342745737131796L;

@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
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