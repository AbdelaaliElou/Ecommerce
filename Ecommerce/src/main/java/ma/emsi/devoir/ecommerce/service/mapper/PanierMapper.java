package ma.emsi.devoir.ecommerce.service.mapper;

import org.mapstruct.Mapper;

import ma.emsi.devoir.ecommerce.domaine.PanierVO;
import ma.emsi.devoir.ecommerce.entity.Panier;

@Mapper(uses = {UserMapper.class})
public interface PanierMapper extends EntityMapper<Panier,PanierVO >{

	
	

}
