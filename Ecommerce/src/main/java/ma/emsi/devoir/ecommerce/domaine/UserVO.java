package ma.emsi.devoir.ecommerce.domaine;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;;


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
	
	
    private RoleVO roleVO;
    


}
