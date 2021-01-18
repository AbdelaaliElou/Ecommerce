package ma.emsi.devoir.ecommerce.service.mapper;

import java.util.List;


public interface EntityMapper<E,D> {
	
	
	E toEntity(D dto);
	D toDto(E entity);
	List<E> toEntity(List<D> listDto);
	List<D> toDto(List<E> listEntity);
}
