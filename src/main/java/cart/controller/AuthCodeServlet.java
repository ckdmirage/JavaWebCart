package cart.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user/authcode")
public class AuthCodeServlet extends HttpServlet {
	private String generateAuthcode(){
		String chars = "0123456789";//abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
		StringBuffer authcode = new StringBuffer();
		Random random = new Random();
		for(int i=0;i<4;i++) {
			int index = random.nextInt(chars.length());
			authcode.append(chars.charAt(index));
		}
		return authcode.toString();
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random random = new Random();
		String authcode = generateAuthcode();
		ImageIO.write(getAuthCodeImage(authcode),"JPEG",resp.getOutputStream());
		
		//存入
		HttpSession session = req.getSession();
		session.setAttribute("authcode", authcode);
		ImageIO.write(getAuthCodeImage(authcode), "JPEG", resp.getOutputStream());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	private BufferedImage getAuthCodeImage(String authcode) {
		BufferedImage img = new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		
		g.setColor(Color.YELLOW);
		
		g.fillRect(0, 0, 80, 30);
		
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 22));
		g.drawString(authcode, 18, 22);
		
		Random random = new Random();
		for(int i=0 ; i<15; i++) {
			int x1 = random.nextInt(80);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(80);
			int y2 = random.nextInt(30);
			g.drawLine(x1, y1, x2, y2);
		}
		
		return img;
	}
}
