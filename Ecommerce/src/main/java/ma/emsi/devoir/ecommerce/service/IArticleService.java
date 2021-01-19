package ma.emsi.devoir.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;

import ma.emsi.devoir.ecommerce.domaine.ArticleVO;
import ma.emsi.devoir.ecommerce.entity.Article;


public interface IArticleService extends ICrudService<ArticleVO,Article>{
	Page<ArticleVO> findByPriceRange(Double min, Double max);
	List<ArticleVO> findAll(int pageId, int size);
}
