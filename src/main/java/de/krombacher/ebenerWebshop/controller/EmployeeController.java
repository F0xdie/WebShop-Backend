package de.krombacher.ebenerWebshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.krombacher.ebenerWebshop.domain.Employee;
import de.krombacher.ebenerWebshop.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository userRepository;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<Employee>> find() {
		List<Employee> userList = (List<Employee>)userRepository.findAll();
		if(userList.size()==0) {
			return new ResponseEntity<List<Employee>>(userList, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(userList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{persNr}", method=RequestMethod.GET)
	public Employee findById(@PathVariable("persNr")String persNr) {
		return userRepository.findByPersNr(persNr);
	}
	
	@RequestMapping(value="/save" , method=RequestMethod.POST)
	public Employee createUser(@RequestBody Employee postUser) {
		return userRepository.save(postUser);
	}
	
	@RequestMapping(value="/delete/{persNr}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("persNr") Long persNr) {
		userRepository.delete(persNr);
	}
	
	
}
