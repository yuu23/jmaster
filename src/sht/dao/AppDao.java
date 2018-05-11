package sht.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppDao {
	public List<String> findAll(){
		PreparedStatement st = null;
		ResultSet rs = null;

	try {
		// 2.DBから名前とパス取得
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/sample2?serverTimezone=UTC&useSSL=false";
			String user = "student";
			String pass = "himitu";

			Connection con = DriverManager.getConnection(url,user,pass);

			// SQL文の作成
			String sql = "SELECT * FROM user";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// SQLの実行
			rs = st.executeQuery();
			List<String> list = new ArrayList<String>();
			while(rs.next()) {
				String name = rs.getString("name"); // コードのカラム名
				String pw = rs.getString("pass");
				list.add(name);
				list.add(pw);
			}
			return list;
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}
}