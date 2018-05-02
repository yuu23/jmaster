package sht.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlusServlet4")
public class PlusServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの読み込み
		String num1 = request.getParameter("value1");
		String num2 = request.getParameter("value2");

		// 足し算の実行
		int i1 = Integer.parseInt(num1);
		int i2 = Integer.parseInt(num2);
		int answer = i1 + i2;

		// リクエストスコープに必要なデータを入れる
		request.setAttribute("data1", new Integer(i1)); // 「i1」だけでもok ただ参照型と明示的にするためにこのやり方でやっている
		request.setAttribute("data2", new Integer(i2));
		request.setAttribute("answer", new Integer(answer));

		// リクエストをAnswerServletに転送する
		RequestDispatcher rd = request.getRequestDispatcher("/AnswerServlet");
		rd.forward(request, response);
	}
}