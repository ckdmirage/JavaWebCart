package cart.controller;

import java.io.IOException;
import java.util.Base64;

import cart.service.ProductService;
import cart.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@WebServlet("/product/add")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class ProductAddServlet extends HttpServlet {
	
	private ProductService productService = new ProductServiceImpl();
	//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productName = req.getParameter("productName");
		String price = req.getParameter("price");
		String qty = req.getParameter("qty");
		
		Part productImage = req.getPart("productImage");
		
		byte[] bytes = productImage.getInputStream().readAllBytes();
		String productImasgeBase64 = Base64.getEncoder().encodeToString(bytes).trim();
		
		productService.add(productName, price, qty, productImasgeBase64);
		
		String message = String.format("商品新增成功!<p/>商品名稱:%s<p/>商品價格:%s<p/>商品庫存:%s<p/>商品圖片:<img src='data:image/png;base64,%s'><p/>", 
					productName,price,qty,productImasgeBase64);
		req.setAttribute("result","商品新增");
		req.setAttribute("resultMessage", message);
		req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
	}


}
