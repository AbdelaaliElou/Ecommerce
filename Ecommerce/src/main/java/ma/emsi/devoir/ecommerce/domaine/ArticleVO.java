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

public class ArticleVO {
	
	private Long id;
	private String reference;

	private String designation;

	private double price;

}
