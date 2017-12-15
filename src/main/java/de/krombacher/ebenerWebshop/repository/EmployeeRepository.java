package de.krombacher.ebenerWebshop.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import de.krombacher.ebenerWebshop.domain.Employee;


public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	public Employee findByPersNr(String persNr);

	public List<Employee> findAll();

}
