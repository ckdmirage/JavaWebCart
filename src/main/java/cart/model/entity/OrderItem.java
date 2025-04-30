package cart.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
	private Integer itemId;
	private Integer orderId;
	private Integer productId;
	private Integer quantity;
}
