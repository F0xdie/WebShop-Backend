package de.krombacher.ebenerWebshop.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "article")
public class Article {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long articleID;

	@Column(name = "serial_nr")
	private String serialNr;

	@Column
	private String description;

	@Column
	private Integer stock;

	@Column
	private String eancode;

	@Column
	private Boolean visible;

	@JsonIgnore
	@OneToMany(mappedBy = "article")
	private List<OrderPosition> orderPositions;

	@ManyToOne
	@JoinColumn(name = "storage_location_id")
	@JsonManagedReference
	private StorageLocation storageLocation;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonManagedReference
	private Category category;

	public Article() {

	}

	public Long getArticleID() {
		return articleID;
	}

	public void setArticleID(Long articleID) {
		this.articleID = articleID;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<OrderPosition> getOrderPositions() {
		return orderPositions;
	}

	public void setOrderPositions(List<OrderPosition> orderPositions) {
		this.orderPositions = orderPositions;
	}

	public Long getArticlenr() {
		return articleID;
	}

	public void setArticlenr(Long articlID) {
		this.articleID = articlID;
	}

	public String getSerialNr() {
		return serialNr;
	}

	public void setSerialNr(String serialNr) {
		this.serialNr = serialNr;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getEancode() {
		return eancode;
	}

	public void setEancode(String eancode) {
		this.eancode = eancode;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public StorageLocation getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(StorageLocation storageLocation) {
		this.storageLocation = storageLocation;
	}

}
