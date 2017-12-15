package de.krombacher.ebenerWebshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.krombacher.ebenerWebshop.domain.Article;
import de.krombacher.ebenerWebshop.repository.ArticleRepository;

@Service
public class ArticleService {

	private ArticleRepository articleRepsitory;

	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepsitory = articleRepository;
	}

	public List<Article> getAll() {
		return (List<Article>) this.articleRepsitory.findAll();
	}

	public List<Article> getArticle(Long articleID) {
		return (List<Article>) this.articleRepsitory.findByArticleID(articleID);
	}
	
	public Article updateArticle(Article article) {
        return articleRepsitory.save(article);
    }

	
	public void deleteArticle(Long articleID) {
        Article article = (Article) getArticle(articleID);
        if (article != null) {
        	articleRepsitory.delete(articleID);
        }
	}
}
