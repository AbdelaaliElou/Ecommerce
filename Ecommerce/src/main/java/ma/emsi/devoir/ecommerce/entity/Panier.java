package ma.emsi.devoir.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Panier extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;

	/*
	 * @OneToMany java.util.List<PanierArticleVO> panierArticles;
	 */

}
