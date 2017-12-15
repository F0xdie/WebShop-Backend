package de.krombacher.ebenerWebshop.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.krombacher.ebenerWebshop.domain.Order;


public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

	//public Order findByOrderID(Long orderID);

	public List<Order> findAll();

}
