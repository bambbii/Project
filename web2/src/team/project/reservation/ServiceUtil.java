package team.project.reservation;

import java.sql.Connection;
import java.sql.DriverManager;

public class ServiceUtil {

	// 연결객체 필요
	private static Connection con;

	static {
		System.out.println("Connect...");

		try {

			//싱글톤으로 생성해준 객체!!! (1)
			// 드라이버를 동적으로 가져오는 메소드
			// 오라클드라이버를 동적으로 로딩
			// 확장자는 뺸다 -> oracle.jdbc.driver.OracleDriver.class -> .class 삭제
			// 경로가 잘못되면 ClassNotFoundException 오류 발생
			//Class.forName("oracle.jdbc.OracleDriver");
			
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ORANGE", "1234");

//			System.out.println("ConnectSucess");
//			System.out.println(con);
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println("Connect Fail");
			//e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		
		
		//일반적으로 생성해준 객체 !!! (2)
		try {
			//오라클드라이버를 동적으로 할당!!!
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ORANGE", "1234");
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection fail");
			e.printStackTrace();
			
		}
		
		return con;
		
	} 

}
