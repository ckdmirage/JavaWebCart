package cart.model.dto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cart.dao.OrderDAO;
import cart.service.impl.OrderServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private Integer orderId;
	private Integer userId;
	private Date orderDate;
	
	private List<OrderItemDTO> items = new ArrayList<>();
}
	