package de.krombacher.ebenerWebshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cost_location_assignment")
public class CostLocationAssignment {

	@Id
	@Column(name = "cost_location")
	private String costLocation;
	
	@ManyToOne()
	@JoinColumn(name = "employee_id")
	private Employee employee;


	public CostLocationAssignment() {

	}


	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getCostLocation() {
		return costLocation;
	}

	public void setCostLocation(String costLocation) {
		this.costLocation = costLocation;
	}

}
