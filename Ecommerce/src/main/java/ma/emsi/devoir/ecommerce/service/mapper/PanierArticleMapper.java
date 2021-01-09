package ma.emsi.devoir.ecommerce.service.mapper;

import org.mapstruct.Mapper;

import ma.emsi.devoir.ecommerce.domaine.PanierArticleVO;
import ma.emsi.devoir.ecommerce.entity.PanierArticle;

@Mapper(componentModel = "spring", uses = {PanierMapper.class,ArticleMapper.class})
public interface PanierArticleMapper extends EntityMapper<PanierArticle, PanierArticleVO> {


}
