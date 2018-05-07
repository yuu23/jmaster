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
	// データベースの代わりにこのユーザー名とパスワードを正しいとする
	private static final String USER="user";
	private static final String PASS="pass";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// actionリクエストパラメータの読み込み
		String action = request.getParameter("action");
		if(action.equals("login")){ // ログイン時

			// ログイン時はユーザー名とパスワードを取得
			// パラメータのエラーチェックは省略
			String name = request.getParameter("name");
			String passWord = request.getParameter("pw");

			// ユーザー名とパスワードが一致した場合
			if(name.equals(USER)&&passWord.equals(PASS)) {
				// セッション情報を生成
				HttpSession session = request.getSession();
				// ログイン済みの属性を設定
				session.setAttribute("isLogin", "true");
				out.println("<html><head><title>ShowCart</title></head><body>");
				out.println("<h1>ログイン成功!</h1>");
			} else{
				out.println("<html><head><title>ShowCart</title></head><body>");
				out.println("<h1>ユーザー名またはパスワードが違います</h1>");
			}
		}
	}
}
