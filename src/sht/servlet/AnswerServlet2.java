package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.java.PlusBean;

@WebServlet("/AnswerServlet2")
public class AnswerServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// リクエストスコープからPlusBeanを取り出す
		sht.java.PlusBean bean = (PlusBean)request.getAttribute("plus");

		// 答えの出力
		out.println("<html><head><title>Plus</title></head><body>");
		out.println(bean.getValue1() + "+" + bean.getValue2() + "=" + bean.getAnswer());
		out.println("</body></html>");
	}
}
