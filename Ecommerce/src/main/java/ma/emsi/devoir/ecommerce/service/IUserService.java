package ma.emsi.devoir.ecommerce.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import ma.emsi.devoir.ecommerce.domaine.UserVO;
import ma.emsi.devoir.ecommerce.entity.User;

public interface IUserService extends ICrudService<UserVO, User>, UserDetailsService{

}
