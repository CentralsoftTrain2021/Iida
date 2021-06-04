package web;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil
{
	/*ユーザ名*/
	private static String user="root";
	/*パスワード*/
	private static String pass="rootroot";
	/*サーバ名*/
	private static String servername="localhost:3306";
	/*DB名*/
	private static String dbname="train2021";

	//private Connection con = null;

	public  Connection getConnection()	throws ClassNotFoundException, SQLException
	{
		//if( con != null ) {return con;}

		//DBに接続する
		//ドライバーのロード
		Class.forName("com.mysql.cj.jdbc.Driver");

		//接続の実行とコネクションオブジェクトの取得
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://"
				+servername
				+"/"
				+dbname,
				user,
				pass
			);

		return con;
	}

}
