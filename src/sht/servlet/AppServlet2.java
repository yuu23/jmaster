package sht.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.dao.AppDao2;

@WebServlet("/AppServlet2")
public class AppServlet2 extends HttpServlet {
	// このクラスでやること
	//　ログイン保持機能とログアウト機能をつける


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータの取得
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");

		// DBの情報を持ってくる
		AppDao2 dao2 = new AppDao2();
		List<String> list = dao2.findAll();

		// DBと入力された情報を照らし合わせる
		String dbName = null;
		String dbPw = null;
		dbName = list.get(0);
		dbPw = list.get(1);

		if(dbName.equals(name) && dbPw.equals(pw)) {
			request.setAttribute("name1", name);
			RequestDispatcher rd = request.getRequestDispatcher("/mypage.jsp");
			rd.forward(request,response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
