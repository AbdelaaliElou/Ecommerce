package ma.emsi.devoir.ecommerce.domaine;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.emsi.devoir.ecommerce.entity.User;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PanierVO extends AbstractEntityVO {

	private Long id;
	User user;

	/*
	 * @OneToMany java.util.List<PanierArticleVO> panierArticles;
	 */

}
