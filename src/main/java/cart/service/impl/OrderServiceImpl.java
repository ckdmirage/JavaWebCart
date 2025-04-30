package cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import cart.dao.OrderDAO;
import cart.dao.impl.OrderDAOImpl;
import cart.model.dto.OrderDTO;
import cart.model.dto.OrderItemDTO;
import cart.model.dto.ProductDTO;
import cart.model.entity.Order;
import cart.model.entity.OrderItem;
import cart.service.OrderService;


public class OrderServiceImpl implements OrderService{
	private OrderDAO orderDAO = new OrderDAOImpl();
	
	public void addOrder(Integer userId, List<ProductDTO> cart) {
		Integer quantity = 1;
		Integer orderId = orderDAO.addOrder(userId);
		for(ProductDTO productDTO: cart) {
			orderDAO.addOrderItem(orderId, productDTO.getProductId(), quantity);
		}
	}
	
	public List<OrderDTO> findAllOrdersByUserId(Integer userId){
		List<OrderDTO> orderDTOs = new ArrayList<>();
		
		List<Order> orders = orderDAO.findAllOrdersByUserId(userId);
		
		for(Order order: orders) {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setOrderId(order.getOrderId());
			orderDTO.setUserId(order.getUserId());
			orderDTO.setOrderDate(order.getOrderDate());
			for(OrderItem item: orderDAO.findAllOrderItemByOrderId(order.getOrderId())) {
				OrderItemDTO orderItemDTO = new OrderItemDTO();
				orderItemDTO.setItemId(item.getItemId());
				orderItemDTO.setOrderId(item.getOrderId());
				orderItemDTO.setProductId(item.getProductId());
				orderItemDTO.setQuantity(item.getQuantity());
				orderDTO.getItems().add(orderItemDTO);
			}
		}
		return orderDTOs;
	}
}
