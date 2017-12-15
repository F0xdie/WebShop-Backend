package de.krombacher.ebenerWebshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import de.krombacher.ebenerWebshop.domain.Article;
import de.krombacher.ebenerWebshop.domain.Category;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

	public Article findByArticleID(Long articleID);	  
	
	public Page<Article> findByVisible(Pageable pageable, Boolean visible);

	public Page<Article> findByDescriptionContainingIgnoreCaseAndVisible(Pageable pageable, String searchQuery, Boolean visible);

	public Page<Article> findByCategoryAndVisible(Pageable pageable, Category category, Boolean visible);

	public Page<Article> findByCategoryAndDescriptionContainingIgnoreCaseAndVisible(Pageable pageRequest,
			Category category, String searchQuery, Boolean visible);

}
