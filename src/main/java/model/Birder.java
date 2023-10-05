
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Oct 4, 2023
 */
@Entity
@Table(name="birder")
public class Birder {
	
	@Id
	@GeneratedValue
	private int id;
	private String birderName;
	/**
	 * 
	 */
	public Birder() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param birderName
	 */
	public Birder(int id, String birderName) {
		super();
		this.id = id;
		this.birderName = birderName;
	}
	/**
	 * @param birderName
	 */
	public Birder(String birderName) {
		super();
		this.birderName = birderName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the birderName
	 */
	public String getBirderName() {
		return birderName;
	}
	/**
	 * @param birderName the birderName to set
	 */
	public void setBirderName(String birderName) {
		this.birderName = birderName;
	}
	@Override
	public String toString() {
		return "Birder [id=" + id + ", birderName=" + birderName + "]";
	}
	
	

}
