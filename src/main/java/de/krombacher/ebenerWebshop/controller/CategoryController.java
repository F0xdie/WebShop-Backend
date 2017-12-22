package de.krombacher.ebenerWebshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.krombacher.ebenerWebshop.domain.Category;
import de.krombacher.ebenerWebshop.repository.CategoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping("/")
	public List<Category> find() {
		return (List<Category>) categoryRepository.findAll();
	}
	
	
}
