package ma.emsi.devoir.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.emsi.devoir.ecommerce.dao.UserRepository;
import ma.emsi.devoir.ecommerce.domaine.UserVO;
import ma.emsi.devoir.ecommerce.entity.Role;
import ma.emsi.devoir.ecommerce.entity.User;
import ma.emsi.devoir.ecommerce.service.IUserService;
import ma.emsi.devoir.ecommerce.service.mapper.UserMapper;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserMapper userMapper;
	@Override
	public User saveOrUpdate(UserVO t) {
		// TODO Auto-generated method stub
		
		return userRepository.save(userMapper.toEntity(t));
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public List<UserVO> findAll() {
		// TODO Auto-generated method stub
		
		return userMapper.toDto(userRepository.findAll());
	}

	@Override
	public UserVO findById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.isPresent()?userMapper.toDto(optionalUser.get()):null;
	}

	@Override
	public Page<UserVO> findByCriteria(UserVO t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		System.out.println(user.getPassword());
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthority(user.getRole()));
	}
	
	private Collection<? extends GrantedAuthority> getAuthority(Role role) {
		List<GrantedAuthority> ssAuth = new ArrayList<>();
		ssAuth.add(new SimpleGrantedAuthority(role.getName()));
		return ssAuth;
	}


}
