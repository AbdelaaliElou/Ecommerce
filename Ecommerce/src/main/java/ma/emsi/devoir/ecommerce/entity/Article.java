package ma.emsi.devoir.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name="articles")
public class Article extends AbstractEntity{
	
	
	
	@Column(name="reference")
	private String reference;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="price")
	private double price;
 
	
	

	

}
