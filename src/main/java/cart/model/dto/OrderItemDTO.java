package cart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
	private Integer itemId;
	private Integer orderId;
	private Integer productId;
	private Integer quantity;
}
