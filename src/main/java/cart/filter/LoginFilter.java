package cart.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"/user/list", "/product/list","/product/*"})
public class LoginFilter extends HttpFilter {

	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("userDTO")==null) {
			//response.sendRedirect("/JavaWebCart/user/login");
			request.setAttribute("resultTitle", "請先登入");
			request.setAttribute("resultMessage", "請先登入");
			request.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}

}
/*
 * @WebFilter("/user/*")
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("userDTO") == null) {
            response.sendRedirect("/JavaWebCart/user/login");
            return;
        } else {
            chain.doFilter(request, response);
        }
    }
}
 * */
