package ma.emsi.devoir.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.devoir.ecommerce.entity.Panier;
import ma.emsi.devoir.ecommerce.entity.PanierArticle;

@Repository
public interface PanierArticleRepository extends JpaRepository<PanierArticle, Long> {
	public List<PanierArticle> findByPanier(Panier p);
}
