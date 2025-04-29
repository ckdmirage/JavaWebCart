package cart.controller;

import java.io.IOException;

import cart.model.dto.UserDTO;
import cart.service.UserLoginService;
import cart.service.impl.UserLoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private UserLoginService userLoginService = new UserLoginServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/cart/user_login.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String authcode = req.getParameter("authcode");
		String sessionAuthcode = session.getAttribute("authcode")+"";
		String resultMessage = null;
		try {
			UserDTO userDTO = userLoginService.login(username, password, authcode, sessionAuthcode);
			resultMessage = username + "登入成功!";
			session.setAttribute("userDTO", userDTO);
		}catch(RuntimeException e) {
			resultMessage = e.getMessage();
		}
		
		req.setAttribute("resultTitle", "登入結果");
		req.setAttribute("resultMessage", resultMessage);
		
		req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
	}

}
