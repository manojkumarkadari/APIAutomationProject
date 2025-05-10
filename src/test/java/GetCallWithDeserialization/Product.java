package GetCallWithDeserialization;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
private Integer id;
private String title;
private Double price;
private String Category;
private String description;
private String image;
private Rating rating;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public static class Rating{
	private Double rate;
	private Integer count;
}

}
