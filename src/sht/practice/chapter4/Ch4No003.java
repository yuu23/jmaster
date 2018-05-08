package sht.practice.chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ch4No003
 */
@WebServlet("/Ch4No003")
public class Ch4No003 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String userId = request.getParameter("user");
		String pw = request.getParameter("pass");
		String mail = request.getParameter("mail");

		if(userId == null || userId.length() == 0 || pw == null
				|| pw.length() == 0 || mail == null || mail.length() == 0) {
			// 未入力データあり
			showNotEnterdError(out);
			return;
		}else {
		out.println("<html><head><title>Ch4No003</title></head><body>");
		out.println("<h3>入力された情報は下記の通りでよろしいですか</h3>");
		out.println("<h4>ユーザー名: <small>" + userId + "</small></h4>");
		out.println("<h4>パスワード: <small>" + pw + "</small></h4>");
		out.println("<h4>メールアドレス: <small>" + mail + "</small></h4>");
	}
		out.println("</body></html>");
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void showNotEnterdError(PrintWriter out) {
		out.println("<html><head><title><Plus</title></head><body>");
		out.println("<h1>未入力の欄があります</h1>");
		out.println("</body></html>");
		}

}
