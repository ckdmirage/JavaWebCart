package cart.controller;

import java.io.IOException;

import cart.service.UserRegisterService;
import cart.service.impl.UserRegisterServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/email/confirm")
public class EmailConfirmServlet extends HttpServlet{

	private UserRegisterService userRegisterService = new UserRegisterServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		String username = req.getParameter("username");
		userRegisterService.emailConfirmOK(username);
		
		String resultTitle = "Emial驗證結果";
		String resultMessage = "用戶名稱"+ username + "<p />Email驗證成功";
		req.setAttribute("resultTitle", resultTitle);
		req.setAttribute("resultMessage", resultMessage);
		
		req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
	}

}
