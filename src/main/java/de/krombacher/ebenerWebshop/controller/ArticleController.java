package de.krombacher.ebenerWebshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.krombacher.ebenerWebshop.domain.Article;
import de.krombacher.ebenerWebshop.domain.Category;
import de.krombacher.ebenerWebshop.repository.ArticleRepository;
import de.krombacher.ebenerWebshop.repository.CategoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/articles")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Page<Article>> findAll(@RequestParam(name="page", defaultValue = "0")Integer page,
											     @RequestParam(name="size", defaultValue = "10") Integer size,
											     @RequestParam(name="visible", defaultValue="true")Boolean visible,
											     @RequestParam(name="searchQuery", defaultValue="") String searchQuery,
											     @RequestParam(name = "category",defaultValue="")String categoryName){
		
		Pageable pageRequest = new PageRequest(page,size, Sort.Direction.ASC, "description");
		
		Page<Article> articleList = null;
		if(!searchQuery.equals("") && categoryName.equals("")) {
			articleList = (Page<Article>) articleRepository.findByDescriptionContainingIgnoreCaseAndVisible(pageRequest,searchQuery, visible);
		}else if(!categoryName.equals("")) {
			Category category = categoryRepository.findByName(categoryName);
			if(category != null) {
				if(searchQuery.equals("")) {
					articleList = articleRepository.findByCategoryAndVisible(pageRequest ,category, visible);
				} else {
					articleList = articleRepository.findByCategoryAndDescriptionContainingIgnoreCaseAndVisible(pageRequest,category,searchQuery, visible);
				}
			}else {
				return new ResponseEntity<Page<Article>>(HttpStatus.BAD_REQUEST);
			}
			
		}else {
			articleList = articleRepository.findByVisible(pageRequest, visible);
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return new ResponseEntity<Page<Article>>(articleList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
	public Article findById(@PathVariable("articleId") Long articleID) {
		return articleRepository.findByArticleID(articleID);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Article createArticle(@RequestBody Article postArticle) {
		return articleRepository.save(postArticle);
	}

	@RequestMapping(value = "/delete/{articleId}", method = RequestMethod.DELETE)
	public void deleteArticle(@PathVariable("articleId") Long articleID) {
		articleRepository.delete(articleID);
	}

}
