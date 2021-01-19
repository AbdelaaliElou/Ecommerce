package ma.emsi.devoir.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ma.emsi.devoir.ecommerce.dao.RoleRepository;
import ma.emsi.devoir.ecommerce.domaine.RoleVO;
import ma.emsi.devoir.ecommerce.entity.Role;
import ma.emsi.devoir.ecommerce.service.IRoleService;
import ma.emsi.devoir.ecommerce.service.mapper.RoleMapper;

@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	RoleRepository roleRepository;
	@Override
	public Role saveOrUpdate(RoleVO t) {
		// TODO Auto-generated method stub
		return roleRepository.save(roleMapper.toEntity(t));
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
	}

	@Override
	public List<RoleVO> findAll() {
		// TODO Auto-generated method stub
		return roleMapper.toDto(roleRepository.findAll());
	}

	@Override
	public RoleVO findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Role> optionalRole=roleRepository.findById(id);
		return optionalRole.isPresent()? roleMapper.toDto(optionalRole.get()):null;
	}

	@Override
	public Page<RoleVO> findByCriteria(RoleVO t) {
		// TODO Auto-generated method stub
		return null;
	}

}
