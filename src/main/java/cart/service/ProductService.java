package cart.service;

import java.util.List;

import cart.model.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> findAllProducts();
	
	void add(String productName, String price, String qty, String productImageBase64);
	
	void delete(Integer productId);
}
