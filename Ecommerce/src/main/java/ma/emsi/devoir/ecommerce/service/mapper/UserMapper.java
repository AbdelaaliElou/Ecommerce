package ma.emsi.devoir.ecommerce.service.mapper;

import org.mapstruct.Mapper;

import ma.emsi.devoir.ecommerce.domaine.UserVO;
import ma.emsi.devoir.ecommerce.entity.User;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper extends EntityMapper<User,UserVO>{

}
