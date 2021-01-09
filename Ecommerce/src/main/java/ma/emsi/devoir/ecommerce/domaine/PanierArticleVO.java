package ma.emsi.devoir.ecommerce.domaine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PanierArticleVO extends AbstractEntityVO {

	PanierVO panierVO;

	ArticleVO articleVO;

	int amount;
}
