package de.krombacher.ebenerWebshop.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.krombacher.ebenerWebshop.domain.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

	Category findByName(String categoryName);
	
}
