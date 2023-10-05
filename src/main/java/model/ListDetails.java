package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Amy Miles
 * CIS 175 - Fall 2023
 * Oct 4, 2023
 */
@Entity
public class ListDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate tripDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Birder birder;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)	
	private List<Sighting> listOfSightings;
	
	/**
	 * 
	 */
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param listName
	 * @param tripDate
	 * @param birder
	 * @param listOfSightings
	 */
	public ListDetails(int id, String listName, LocalDate tripDate, Birder birder, List<Sighting> listOfSightings) {
		super();
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.birder = birder;
		this.listOfSightings = listOfSightings;
	}
	/**
	 * @param listName
	 * @param tripDate
	 * @param birder
	 * @param listOfSightings
	 */
	public ListDetails(String listName, LocalDate tripDate, Birder birder, List<Sighting> listOfSightings) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.birder = birder;
		this.listOfSightings = listOfSightings;
	}
	/**
	 * @param listName
	 * @param tripDate
	 * @param birder
	 */
	public ListDetails(String listName, LocalDate tripDate, Birder birder) {
		super();
		this.listName = listName;
		this.tripDate = tripDate;
		this.birder = birder;
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
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}
	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	/**
	 * @return the tripDate
	 */
	public LocalDate getTripDate() {
		return tripDate;
	}
	/**
	 * @param tripDate the tripDate to set
	 */
	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}
	/**
	 * @return the birder
	 */
	public Birder getBirder() {
		return birder;
	}
	/**
	 * @param birder the birder to set
	 */
	public void setBirder(Birder birder) {
		this.birder = birder;
	}
	/**
	 * @return the listOfSightings
	 */
	public List<Sighting> getListOfSightings() {
		return listOfSightings;
	}
	/**
	 * @param listOfSightings the listOfSightings to set
	 */
	public void setListOfSightings(List<Sighting> listOfSightings) {
		this.listOfSightings = listOfSightings;
	}
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", birder=" + birder
				+ ", listOfSightings=" + listOfSightings + "]";
	}
	
	
}
