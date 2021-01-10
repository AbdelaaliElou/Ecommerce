package ma.emsi.devoir.ecommerce.service;

import java.util.Map;

import ma.emsi.devoir.ecommerce.domaine.ArticleVO;
import ma.emsi.devoir.ecommerce.domaine.PanierVO;
import ma.emsi.devoir.ecommerce.entity.Panier;

public interface IPanierService extends ICrudService<PanierVO, Panier> {
	void saveOrUpdate(Map<ArticleVO, Integer> mapArticles);
}
