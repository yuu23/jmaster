package sht.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.dao.AppDao;

@WebServlet("/AppServlet")
public class AppServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.リクエストパラメータの取得
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");


		AppDao dao = new AppDao();
		List<String> list = dao.findAll();

//		try {
//		// 2.DBから名前とパス取得
//			Class.forName("com.mysql.jdbc.Driver");
//
//			String url = "jdbc:mysql://localhost/sample2?serverTimezone=UTC&useSSL=false";
//			String user = "student";
//			String pass = "himitu";
//
//			Connection con = DriverManager.getConnection(url,user,pass);
//
//			String sql = "SELECT * FROM user";
//			PreparedStatement st = con.prepareStatement(sql);
//			ResultSet rs = st.executeQuery(); // selectした結果のレコードを参照している状態


			// AppDao使用の場合
			String dbName = null;
			String dbPw = null;
//			while(ts.next()) {
//				dbName = rs.getString("name");
//				dbPw = rs.getString("pass");
//			}
			dbName = list.get(0);
			dbPw = list.get(1);

			if(dbName.equals(name) && dbPw.equals(pw)) {
				request.setAttribute("name1",name); // 名前を表示
				RequestDispatcher rd = request.getRequestDispatcher("/mypage.jsp"); // mypage.jspにフォワード
				rd.forward(request,response);
			}

//			st.close();
//			con.close();
//		}catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
