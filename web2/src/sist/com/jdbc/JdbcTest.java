package sist.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {
	private static Connection con;
	static {
		System.out.println("Connect.....");
		try {
			//오라클드라이버를 동적으로 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ORANGE", "1234");
			System.out.println("Connect Success");
			System.out.println(con);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connect Fail");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
