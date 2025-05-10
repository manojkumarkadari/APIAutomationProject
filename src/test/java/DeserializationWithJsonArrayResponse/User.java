package DeserializationWithJsonArrayResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User{
	private int id;
	private String email;
	private String gender;
	private String name;
	private String status;
	
}