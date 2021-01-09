package ma.emsi.devoir.ecommerce.domaine;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author rkarami
 *
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RoleVO extends AbstractEntityVO {
	
	
	private String name;

	

}
