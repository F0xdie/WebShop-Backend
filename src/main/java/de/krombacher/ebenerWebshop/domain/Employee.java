package de.krombacher.ebenerWebshop.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true)
	private String persNr;

	@Column
	private String name;

	@Column
	private String firstname;

	@Column
	private String mail;

	@Column(name = "phone_nr")
	private String phoneNr;

	@Column(name = "cost_location")
	private String costLocation;
	
	@OneToMany(mappedBy="employee")
	private List<CostLocationAssignment> costLocationAssignment;
	
	public Employee() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersNr() {
		return persNr;
	}

	public void setPersNr(String persNr) {
		this.persNr = persNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public String getCostLocation() {
		return costLocation;
	}

	public void setCostLocation(String costLocation) {
		this.costLocation = costLocation;
	}

}
