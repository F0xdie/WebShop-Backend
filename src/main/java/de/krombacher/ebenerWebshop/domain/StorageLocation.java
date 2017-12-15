package de.krombacher.ebenerWebshop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="storage_location")
public class StorageLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="location_name", unique=true)
	private String locationName;
	
	@JsonBackReference
	@OneToMany(mappedBy = "storageLocation", cascade = CascadeType.ALL)
	public List<Article> articleList;
	
	
	public StorageLocation() {
		articleList = new ArrayList<Article>();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLocationName() {
		return locationName;
	}


	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}


	public List<Article> getArticleList() {
		return articleList;
	}


	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
	
	
}
