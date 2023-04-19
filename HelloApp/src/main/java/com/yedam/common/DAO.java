package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB접속하는 커넥션 객체를 만들어서 반환해주는 클래스
//Connection 객체 반환.
public class DAO {

	public static Connection getConnect() {
		//jdbc 연결 접속 조회
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn; //변수를 선언해주려면 항상 초기화 해야한다.
	}
	
}
