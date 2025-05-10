package FakeUserAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class FakeUser {
	private String email;
	private String username;
	private String password;
	private String phone;

	public static class address{
		private String city;
		private String street;
		private String number;
		private String zipcode;
		private geolocation geolocation;
		
		public static class geolocation{
			private String lat;
			@JsonProperty("long")
			private String longitude;
			
		}
		
	}

}
