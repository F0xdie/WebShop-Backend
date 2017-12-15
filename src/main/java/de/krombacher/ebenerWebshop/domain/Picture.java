package de.krombacher.ebenerWebshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "picture")
public class Picture {

	@Id
	@GeneratedValue
	@Column(name = "picture_id")
	private Long pictureID;

	@Column
	private String path;

	@Column(name = "article_nr")
	private Long articleNr;

	public Long getPictureID() {
		return pictureID;
	}

	public void setPictureID(Long pictureID) {
		this.pictureID = pictureID;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getArticleNr() {
		return articleNr;
	}

	public void setArticleNr(Long articleNr) {
		this.articleNr = articleNr;
	}

}
