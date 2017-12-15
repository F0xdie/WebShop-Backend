package de.krombacher.ebenerWebshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collective_cost_location")
public class CollectiveCostLocation {

	@Id
	@GeneratedValue
	@Column(name = "cost_location")
	private Long costLocation;

	@Column(name = "cost_location_name")
	private String costLocationName;

	public Long getCostLocation() {
		return costLocation;
	}

	public void setCostLocation(Long costLocation) {
		this.costLocation = costLocation;
	}

	public String getCostLocationName() {
		return costLocationName;
	}

	public void setCostLocationName(String costLocationName) {
		this.costLocationName = costLocationName;
	}

}
