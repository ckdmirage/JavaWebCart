package cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import cart.model.dto.ProductDTO;
import cart.service.ProductService;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<ProductDTO> findAllProducts() {
		 List<ProductDTO> p = new ArrayList<ProductDTO>();
		return p;
	}

	@Override
	public void add(String productName, String price, String productImageBase64) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer productId) {
		// TODO Auto-generated method stub
		
	}
	

}
