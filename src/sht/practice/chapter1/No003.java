package sht.practice.chapter1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/No003")
public class No003 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			String num1 = request.getParameter("value");

			int i1 = Integer.parseInt(num1);
			int answer = i1 * 100;


			out.println("<html><head><title>No003</title></head><body>");
			out.println(answer);
			out.println("</body></html>");
	}
}
