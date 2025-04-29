package cart.dao;

import java.util.List;

import cart.model.entity.Product;

public interface ProductDAO {
	
	List<Product> findAllProducts();
	
	void add(Product product);
	
	void delete(Integer productId);
	
	//Product findById();
}
