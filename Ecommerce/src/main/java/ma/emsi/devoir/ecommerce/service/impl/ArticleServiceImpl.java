package ma.emsi.devoir.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ma.emsi.devoir.ecommerce.dao.ArticleRepository;
import ma.emsi.devoir.ecommerce.domaine.ArticleVO;
import ma.emsi.devoir.ecommerce.entity.Article;
import ma.emsi.devoir.ecommerce.service.IArticleService;
import ma.emsi.devoir.ecommerce.service.mapper.ArticleMapper;

@Service
public class ArticleServiceImpl implements IArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public void saveOrUpdate(ArticleVO articleVO) {
		
		articleRepository.save(articleMapper.toEntity(articleVO));
	}

	@Override
	public void delete(long id) {
		
		articleRepository.deleteById(id);

	}
	/**
	 * @return list<<ArticleVO>
	 * */
	@Override
	public List<ArticleVO> findAll() {
		
		return articleMapper.toDto(articleRepository.findAll());
	}

	@Override
	public ArticleVO findById(Long id) {
		
		Optional<Article> optionalArticle=articleRepository.findById(id);
		return optionalArticle.isPresent()? articleMapper.toDto(optionalArticle.get()):null;
	}
	@Override
	public Page<ArticleVO> findByCriteria(ArticleVO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ArticleVO> findByPriceRange(Double min, Double max) {
		// TODO Auto-generated method stub
		return null;
	}

}
