package de.krombacher.ebenerWebshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.krombacher.ebenerWebshop.domain.Article;
import de.krombacher.ebenerWebshop.domain.Employee;
import de.krombacher.ebenerWebshop.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	public EmployeeRepository userRepository;
	
	public EmployeeService (EmployeeRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<Employee> getAll() {
		return (List<Employee>) this.userRepository.findAll();
	}

	public List<Employee> getUser(String persNr) {
		return (List<Employee>) this.userRepository.findByPersNr(persNr);
	}
	
	public Employee updateUser(Employee user) {
        return userRepository.save(user);
    }

	
	public void deleteUser(String persNr) {
		Employee user = (Employee) getUser(persNr);
        if (user != null) {
        	userRepository.delete(user);
        }
	}

}
