package de.krombacher.ebenerWebshop.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_position")
public class OrderPosition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManyToOne
	@JoinColumn(name = "article_id_id")
	@Id
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "order_id_id")
	@Id
	private Order order;
	
	@Column
	private Integer amount;
	
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	

}
