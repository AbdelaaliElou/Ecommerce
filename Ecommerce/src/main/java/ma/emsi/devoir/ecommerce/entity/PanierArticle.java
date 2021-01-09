package ma.emsi.devoir.ecommerce.entity;

import javax.persistence.Column;
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
public class PanierArticle  extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="panier_id")
	Panier panier;
    
    @ManyToOne
    @JoinColumn(name="article_id")
	Article article;
   
    @Column(name="amount")
	int amount;
}
