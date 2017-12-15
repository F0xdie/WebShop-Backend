package de.krombacher.ebenerWebshop.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Column(name = "article_nr")
	private Long articleNr;

	@Column
	private Long price;

	@Column
	private String valid;

	@Column(name = "valid_from")
	private Date validFrom;

	@Column(name = "valid_until")
	private Date validUntil;

	@Column
	private String visible;

	@ManyToOne
	@JoinColumn(name = "article_id_id")
	private Article article;

	public Article getArticle() {
		return article;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArticleNr() {
		return articleNr;
	}

	public void setArticleNr(Long articleNr) {
		this.articleNr = articleNr;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

}
