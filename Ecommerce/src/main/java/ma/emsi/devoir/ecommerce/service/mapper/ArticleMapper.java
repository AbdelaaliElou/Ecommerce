package ma.emsi.devoir.ecommerce.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ma.emsi.devoir.ecommerce.domaine.ArticleVO;
import ma.emsi.devoir.ecommerce.entity.Article;



@Mapper
public interface ArticleMapper extends EntityMapper<Article,ArticleVO> {
	@Mapping(target = "file", ignore=true)
	ArticleVO toDto(Article entity);
}
