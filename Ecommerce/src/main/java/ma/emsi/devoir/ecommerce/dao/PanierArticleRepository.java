package ma.emsi.devoir.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.devoir.ecommerce.entity.PanierArticle;

@Repository
public interface PanierArticleRepository extends JpaRepository<PanierArticle, Long> {

}
