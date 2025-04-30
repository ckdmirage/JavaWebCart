package cart.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
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
		return products;
	}
	
	public void add(Product product) {
		String sql = "insert into product(product_name, price, qty, image_base64) values(?, ?, ?, ?)";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setInt(3, product.getQty());
			pstmt.setString(4,product.getImageBase64());
			
			int rowcount = pstmt.executeUpdate();
			System.out.println("新增商品:" + rowcount);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Integer productId) {
		String sql = "delete from product where product_id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, productId);
			int rowcount = pstmt.executeUpdate();
			System.out.println("刪除商品筆數:" + rowcount);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
