package tn.esprit.spring.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class FileDB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5981557505349268959L;
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String name;

  private String type;
  
  /* LOB is datatype for storing large object data. There’re two kinds of LOB: BLOB and CLOB:

BLOB is for storing binary data
CLOB is for storing text data*/

  @Lob
  private byte[] data;
  
  

public FileDB(String name, String type, byte[] data) {
	super();
	this.name = name;
	this.type = type;
	this.data = data;
}

public FileDB() {
	super();
}



public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public byte[] getData() {
	return data;
}

public void setData(byte[] data) {
	this.data = data;
}


}