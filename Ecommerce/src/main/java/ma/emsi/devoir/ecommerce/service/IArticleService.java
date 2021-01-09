package ma.emsi.devoir.ecommerce.service;

import org.springframework.data.domain.Page;

import ma.emsi.devoir.ecommerce.domaine.ArticleVO;


public interface IArticleService extends ICrudService<ArticleVO>{
	
	Page<ArticleVO> findByPriceRange(Double min, Double max);
}
