package cart.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cart.dao.BaseDao;
import cart.dao.ProductDAO;
import cart.model.entity.Product;

public class PorductDAOImpl extends BaseDao implements ProductDAO{

	public List<Product> findAllProducts(){
		List<Product> products = new ArrayList<>();
		String sql = "select product_id, product_name, price, qty, image_base64 from product";
		try(Statement stmt= conn.createStatement()){
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setPrice(rs.getInt("price"));
				product.setQty(rs.getInt("qty"));
				product.setImageBase64(rs.getString("image_base64"));
				products.add(product);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void add(Product product) {
		
	}
	
	public void delete(Integer productId) {
		
	}
}
