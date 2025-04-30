package cart.dao;

import java.util.List;

import cart.model.entity.Order;
import cart.model.entity.OrderItem;

public interface OrderDAO {
	Integer addOrder(Integer userId);
	
	void addOrderItem(Integer orderId, Integer productId, Integer quantity);
	
	List<Order> findAllOrdersByUserId(Integer userId);
	
	List<OrderItem> findAllOrderItemByOrderId(Integer orderId);
	
}
