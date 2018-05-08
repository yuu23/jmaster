package sht.practice.chapter2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Ch2No003")
public class Ch2No003 extends HttpServlet {
	private static final String USER="user";
	private static final String PASS="pass";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		if(action.equals("login")){

			String name = request.getParameter("name");
			String passWord = request.getParameter("pw");

			if(name.equals(USER)&&passWord.equals(PASS)) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", "true");
				out.println("<html><head><title>no003</title></head><body>");
				out.println("<h1>ログイン成功</h1>");
			} else{
				out.println("<html><head><title>no003</title></head><body>");
				out.println("<h1>ログイン失敗</h1>");
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}