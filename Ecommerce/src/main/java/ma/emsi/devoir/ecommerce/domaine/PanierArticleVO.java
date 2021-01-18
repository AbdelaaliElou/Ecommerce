package ma.emsi.devoir.ecommerce.domaine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.emsi.devoir.ecommerce.entity.Article;
import ma.emsi.devoir.ecommerce.entity.Panier;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PanierArticleVO extends AbstractEntityVO {
	
	private Long id;
	Panier panier;

	Article article;

	int amount;
}
