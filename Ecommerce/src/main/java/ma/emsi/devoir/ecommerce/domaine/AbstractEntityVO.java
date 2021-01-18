package ma.emsi.devoir.ecommerce.domaine;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractEntityVO {

	private Date createdAt;

	private Date updatedAt;

}
