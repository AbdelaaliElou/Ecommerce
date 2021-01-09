package ma.emsi.devoir.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.devoir.ecommerce.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
}
