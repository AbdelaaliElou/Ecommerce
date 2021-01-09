package ma.emsi.devoir.ecommerce.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ma.emsi.devoir.ecommerce.domaine.PanierVO;
import ma.emsi.devoir.ecommerce.service.IPanierService;

@Service
public class PanierServiceImpl implements IPanierService {

	@Override
	public void saveOrUpdate(PanierVO t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PanierVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PanierVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PanierVO> findByCriteria(PanierVO t) {
		// TODO Auto-generated method stub
		return null;
	}

}
