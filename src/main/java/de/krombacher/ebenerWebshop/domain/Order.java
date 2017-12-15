package de.krombacher.ebenerWebshop.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import de.krombacher.ebenerWebshop.enumerations.OrderStatus;

@Entity
@Table(name = "article_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long orderId;

	@Column(name = "customer_nr")
	private Long customerNr;

	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "total_price")
	private String totalPrice;

	@Column
	@Enumerated(EnumType.STRING)
	private OrderStatus state;

	@Column(name = "booking_nr")
	private Long bookingNr;

	@Column
	private Boolean booked;

	@Column(name = "booking_date")
	private Date bookingDate;

	@Column(name = "cost_location")
	private String costLocation;

	@Column
	private String name;

	@Column
	private String firstname;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	public List<OrderPosition> orderPositions;
	
	public Order() {
		orderPositions = new ArrayList<OrderPosition>();
	}
	
	public List<OrderPosition> getOrderPositions() {
		return orderPositions;
	}
	
	public void setOrderPositions(List<OrderPosition> orderPositions) {
		this.orderPositions = orderPositions;
	}
	
	public Long getOrderID() {
		return orderId;
	}

	public void setOrderID(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerNr() {
		return customerNr;
	}

	public void setCustomerNr(Long customerNr) {
		this.customerNr = customerNr;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderStatus getState() {
		return state;
	}

	public void setState(OrderStatus state) {
		this.state = state;
	}

	public Long getBookingNr() {
		return bookingNr;
	}

	public void setBookingNr(Long bookingNr) {
		this.bookingNr = bookingNr;
	}

	public Boolean getBooked() {
		return booked;
	}

	public void setBooked(Boolean booked) {
		this.booked = booked;
	}

	public String getCostLocation() {
		return costLocation;
	}

	public void setCostLocation(String costLocation) {
		this.costLocation = costLocation;
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


}
