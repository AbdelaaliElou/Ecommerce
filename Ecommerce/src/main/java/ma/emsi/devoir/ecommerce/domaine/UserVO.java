package ma.emsi.devoir.ecommerce.domaine;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.emsi.devoir.ecommerce.entity.Role;;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class UserVO {

    private Long id;
    
	private String userName;
   
	private String password;
   
	private String login;
    
	private String firstName;
   
	private String lastName;
	
	private String email;

    private String cellPhone;
    
    private String city;
	
    private Role role;
    
    private String img;

}
