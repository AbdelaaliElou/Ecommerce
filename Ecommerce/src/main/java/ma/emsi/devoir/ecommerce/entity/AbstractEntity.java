package ma.emsi.devoir.ecommerce.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@PrePersist
	protected void initCreation() {
		
		createdAt = new Date();
		
	}
		
	@PreUpdate
	protected void initUpdat() {
		
		updatedAt = new Date();
		
	}
	


}
