package de.krombacher.ebenerWebshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.krombacher.ebenerWebshop.domain.Order;
import de.krombacher.ebenerWebshop.repository.OrderRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Page<Order>> findAll() {
		Page<Order> orderList = (Page<Order>) orderRepository.findAll();
	return new ResponseEntity<Page<Order>>(orderList, HttpStatus.OK);
	}
	
	@RequestMapping(value ="/{orderId}", method = RequestMethod.GET)
	public Order findById(@PathVariable("orderId") Long orderId) {
		return orderRepository.findOne(orderId);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Order createOrder(@RequestBody Order postOrder) {
		return orderRepository.save(postOrder);
	}
	
	@RequestMapping(value ="/delete/{orderId}", method = RequestMethod.DELETE)
	public void deleteOrder(@PathVariable("orderId") Long orderId) {
		orderRepository.delete(orderId);
	}

//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public Order createTestOrder() {
//		Order order = new Order();
//		order.setName("Test");
//		order.setFirstname("Markus");
//
//		OrderPosition op = new OrderPosition();
//
//		Article a = new Article();
//		a.setDescription("Testartikel");
//		a.setEancode("12321321321321");
//		a.setStock(5);
//
//		op.setArticle(a);
//		op.setAmount(4);
//		op.setOrder(order);
//
//		order.getOrderPositions().add(op);
//
//		return orderRepository.save(order);
//
//	}
	
	
	
	

}
