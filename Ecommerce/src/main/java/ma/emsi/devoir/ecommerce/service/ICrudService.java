package ma.emsi.devoir.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ICrudService<T,E> {
	
	E saveOrUpdate(T t);
	
	void delete(long id);
	/**
	 * @return List<T>
	 * */
	List<T> findAll();
	
	T findById(Long id);
	
	
	Page<T> findByCriteria(T t);
}
