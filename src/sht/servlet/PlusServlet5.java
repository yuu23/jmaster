package sht.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.java.PlusBean;

@WebServlet("/PlusServlet5")
public class PlusServlet5 extends HttpServlet {
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

		// Beanにまとめる
		PlusBean bean = new PlusBean(i1,i2,answer);
		// リクエストスコープに必要なデータを入れる
		request.setAttribute("plus", bean);

		// リクエストをAnswerServlet2に転送する
		RequestDispatcher rd = request.getRequestDispatcher("/AnswerServlet2");
		rd.forward(request, response);
	}
}
