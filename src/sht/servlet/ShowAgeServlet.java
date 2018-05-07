package sht.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.bean.PersonBean;
import sht.business.CalcAge;

@WebServlet("/ShowAgeServlet")
public class ShowAgeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String strYear = request.getParameter("year");
		String strMonth = request.getParameter("month");
		String strDate = request.getParameter("date");
		// パラメータチェック
		if(strYear == null || strYear.length() == 0 || strMonth == null
				||strMonth.length() == 0 || strDate == null
				|| strDate.length() == 0) {
			request.setAttribute("message", "生年月日を入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forward(request, response);
			return;
		}

		int year,month,date;
		try {
			year = Integer.parseInt(strYear);
			month = Integer.parseInt(strMonth);
			date = Integer.parseInt(strDate);
		} catch (NumberFormatException e) {
			request.setAttribute("message", "生年月日は数値を入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forward(request, response);
			return;
		}

		// モデルを使って年齢を計算する
		CalcAge ca = new CalcAge();
		int age = ca.howOld(year,month,date);

		// 表示データをJavaBeansにする
		PersonBean p = new PersonBean(name,age);
		// JavaBeanをリクエストスコープに入れてJSPにフォワードする
		request.setAttribute("person", p);
		RequestDispatcher rd = request.getRequestDispatcher("/showAge.jsp");
		rd.forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}