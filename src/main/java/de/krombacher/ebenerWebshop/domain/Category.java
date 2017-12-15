package de.krombacher.ebenerWebshop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String name;

	// @OneToOne
	// private Category category;

	@Column(name = "sort_index")
	private Integer sortIndex;

	@JsonBackReference
	@OneToMany(mappedBy = "category")
	private List<Article> articleList;

	public Category() {
		articleList = new ArrayList<Article>();
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}

}
