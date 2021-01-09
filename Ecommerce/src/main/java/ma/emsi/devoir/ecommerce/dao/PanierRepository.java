package ma.emsi.devoir.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.devoir.ecommerce.entity.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long>{

}
