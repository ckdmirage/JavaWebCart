package cart.model.dto;

import lombok.Data;

@Data
public class ProductDTO {
	private Integer productId;
	private String productName;
	private Integer price;
	private Integer qty;
	private String imageBase64;
	
	private Integer total;
}
