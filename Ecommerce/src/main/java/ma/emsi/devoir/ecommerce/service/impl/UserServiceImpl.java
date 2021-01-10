package ma.emsi.devoir.ecommerce.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ma.emsi.devoir.ecommerce.domaine.UserVO;
import ma.emsi.devoir.ecommerce.entity.User;
import ma.emsi.devoir.ecommerce.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Override
	public User saveOrUpdate(UserVO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UserVO> findByCriteria(UserVO t) {
		// TODO Auto-generated method stub
		return null;
	}

}
