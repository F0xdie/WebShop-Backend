package de.krombacher.ebenerWebshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.krombacher.ebenerWebshop.domain.Category;
import de.krombacher.ebenerWebshop.repository.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getAll() {
		return (List<Category>) this.categoryRepository.findAll();
	}
	
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}
	
}
