package ma.emsi.devoir.ecommerce.service.mapper;


import org.mapstruct.Mapper;

import ma.emsi.devoir.ecommerce.domaine.ArticleVO;
import ma.emsi.devoir.ecommerce.entity.Article;



@Mapper
public interface ArticleMapper extends EntityMapper<Article,ArticleVO> {
	
}
