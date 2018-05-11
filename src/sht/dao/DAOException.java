package sht.dao;

public class DAOException extends Exception{

	// コンストラクタ
	public DAOException(String message) {
		super(message); // superクラスのコンストラクタに渡します
	}
}