package ma.emsi.devoir.ecommerce.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ma.emsi.devoir.ecommerce.dao.PanierArticleRepository;
import ma.emsi.devoir.ecommerce.dao.PanierRepository;
import ma.emsi.devoir.ecommerce.domaine.ArticleVO;
import ma.emsi.devoir.ecommerce.domaine.PanierVO;
import ma.emsi.devoir.ecommerce.domaine.UserVO;
import ma.emsi.devoir.ecommerce.entity.Panier;
import ma.emsi.devoir.ecommerce.entity.PanierArticle;
import ma.emsi.devoir.ecommerce.entity.User;
import ma.emsi.devoir.ecommerce.service.IPanierService;
import ma.emsi.devoir.ecommerce.service.mapper.ArticleMapper;
import ma.emsi.devoir.ecommerce.service.mapper.PanierMapper;

@Service
public class PanierServiceImpl implements IPanierService {
	@Autowired
	private PanierRepository panierRepository;
	
	@Autowired
	private PanierMapper panierMapper;
	
	@Autowired
	private PanierArticleRepository panierArticleRepository;
	
	@Autowired
	private ArticleMapper articleMapper;
	
	@Override
	public Panier saveOrUpdate(PanierVO panierVo) {
		Panier p = panierMapper.toEntity(panierVo);
		User u = new User();
		u.setId(1l);
		p.setUser(u);
		return panierRepository.save(p);
	}

	@Override
	public void delete(long id) {
		panierRepository.deleteById(id);
	}

	@Override
	public List<PanierVO> findAll() {
		
		return panierMapper.toDto(panierRepository.findAll());
	}

	@Override
	public PanierVO findById(Long id) {
		
		return panierMapper.toDto(panierRepository.findById(id).orElse(null));
	}

	@Override
	public Page<PanierVO> findByCriteria(PanierVO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Map<ArticleVO, Integer> mapArticles) {
		PanierVO panierVO = new PanierVO();
		UserVO userVo = UserVO.builder().id(1L).build();
		panierVO.setUserVO(userVo);
		Panier panier = saveOrUpdate(panierVO);
		for ( Map.Entry<ArticleVO, Integer> entry: mapArticles.entrySet()) {
			PanierArticle panierArticle = PanierArticle.builder()
					.panier(panier)
					.article(articleMapper.toEntity(entry.getKey()))
					.amount(entry.getValue()).build();
			panierArticleRepository.save(panierArticle);
		}
	}

}
