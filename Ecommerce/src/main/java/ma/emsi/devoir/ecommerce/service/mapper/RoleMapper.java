package ma.emsi.devoir.ecommerce.service.mapper;

import org.mapstruct.Mapper;

import ma.emsi.devoir.ecommerce.domaine.RoleVO;
import ma.emsi.devoir.ecommerce.entity.Role;

@Mapper(componentModel = "spring", uses = {})
public interface RoleMapper extends EntityMapper<Role, RoleVO>{

	

}
