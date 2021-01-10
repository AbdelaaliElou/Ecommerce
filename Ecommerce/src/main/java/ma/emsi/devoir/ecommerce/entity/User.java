package ma.emsi.devoir.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "user")
public class User extends AbstractEntity {

  
    @Column(name="userName",unique=true)
	private String userName;
    
    @Column(name="password")
	private String password;
    
    @Column(name="login")
	private String login;
    
    @Column(name="firstName")
	private String firstName;
    
    @Column(name="lastName")
	private String lastName;
	
    @Column(name="email")
	private String email;
	
    @Column(name="cellPhone", length = 20)
    private String cellPhone;
    
    @Column(name="city")
    private String city;
	@ManyToOne
	@JoinColumn(name="role_id")
    private Role role;
	
	@Column(name="img")
	private String img;
    
}
