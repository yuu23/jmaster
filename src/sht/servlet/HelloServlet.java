package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>HelloServlet</title></head><body>");
//		out.println("<h1>ようこそ!HelloServletへ<h1>");
		for(int i = 0; i < 10; i++) {
			out.println("<h1>ようこそ!</h1>");
		}
		out.println("</body></html>");
	}

}