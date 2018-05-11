package sht.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppDao2 {
	public List<String> findAll(){
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost/sample2?sereverTimezone=UTC&useSSL=false";
			String user = "student";
			String pass = "himitu";
			Connection con = DriverManager.getConnection(url,user,pass);

			String sql = "SELECT * FROM user";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			List<String> list = new ArrayList<String>();
			while(rs.next()) {
				String name = rs.getString("name"); // コードのカラム名
				String pw = rs.getString("pass");
				list.add(name);
				list.add(pw);
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		}
	}