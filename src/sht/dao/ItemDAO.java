package sht.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sht.bean.ItemBean;

public class ItemDAO {
	private Connection con;

	public ItemDAO() throws DAOException {
		getConnection();
	}

	public List<ItemBean> findAll() throws DAOException{

		// 下記のif文がtrueなら、「{」がなくても実行される
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQL文の作成
			String sql = "SELECT * FROM item";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<ItemBean> list = new ArrayList<ItemBean>();
			while(rs.next()) {
				int code = rs.getInt("code"); // コードのカラム名
				String name = rs.getString("name");
				int price = rs.getInt("price");
				ItemBean bean = new ItemBean(code,name,price); // ItemBeanというlistに格納？
				list.add(bean);
			}
			// 商品一覧をListとして返す
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally { // エラーが起きても絶対実行される
			try {
				// リソースの開放
				if(rs != null)rs.close();
				if(rs != null)st.close();
				close();
			}catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public List<ItemBean> sortPrice(boolean isAscending) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			// SQL文の作成
			String sql;
			// ソートキーの指定
			if(isAscending)
				sql = "SELECT * FROM item ORDER BY price";
			else
				sql = "SELECT * FROM item ORDER BY price desc";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<ItemBean> list = new ArrayList<ItemBean>();
			while(rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				ItemBean bean = new ItemBean(code,name,price);
				list.add(bean);
			}
			// 商品一覧をListとして返す
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}finally {
			try {
				// リソースの開放
				if(rs != null)rs.close();
				if(st != null)st.close();
				close();
			}catch(Exception e) {
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	} // 101

	public int addItem(String name,int price) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			// SQL文の作成
			String sql = "INSERT INTO item(name,price)VALUES(?,?)";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// 商品名と値段の指定
			st.setString(1, name);
			st.setInt(2, price);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}finally {
			try {
				// リソースの開放
				if(st != null)st.close();
				close();
			}catch(Exception e) {
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}

	public List<ItemBean> findByPrice(int lePrice) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQLの実行
			String sql = "SELECT * FROM item WHERE price <=?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// 値段のセット
			st.setInt(1,lePrice);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<ItemBean> list = new ArrayList<ItemBean>();
			while(rs.next()) {
				int code = rs.getInt("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				ItemBean bean = new ItemBean(code,name,price);
				list.add(bean);
			}
			// 商品一覧をListとして返す
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}finally {
			try{
				// リソースの開放
				if(rs != null)rs.close();
				if(st != null)st.close();
				close();
			}catch(Exception e) {
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}

	public int deleteByPrimaryKey(int key) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			// SQL文の作成
			String sql = "DELETE FROM item WHERE code = ?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// 主キーの指定
			st.setInt(1, key);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}finally {
			try {
				// リソースの開放
				if(st != null)st.close();
				close();
			}catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました");
			}
		}
	}

	private void getConnection() throws DAOException{
		try {
			// JDBCドライバの登録
			Class.forName("com.mysql.jdbc.Driver");
			// URL、ユーザー名、パスワードの設定
			String url = "jdbc:mysql://localhost/sample2?serverTimezone=UTC&useSSL=false";
			String user = "student";
			String pass = "himitu";
			// データベースへの接続
			con = DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			throw new DAOException("接続に失敗しました。");
		}
	}

	private void close() throws SQLException{
		if(con != null) {
			con.close();
			con = null;
		}
	}
}