package ContactsAPITESTS;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginToken {
	
	private String email;
	private String password;
	
}