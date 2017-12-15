package de.krombacher.ebenerWebshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.krombacher.ebenerWebshop.domain.Order;
import de.krombacher.ebenerWebshop.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<Order> getAll() {
		return (List<Order>) this.orderRepository.findAll();
	}

	public Order getOrder(Long orderId) {
		return this.orderRepository.findOne(orderId);
	}
	
	public Order updateOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public void deleteOrder(Long orderId) {
		Order order = (Order) getOrder(orderId);
		if (order != null) {
			orderRepository.delete(orderId);
		}
	}

}
