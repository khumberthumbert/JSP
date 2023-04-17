package com.yedam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delMemberServlet")
public class DelMemberServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String eid = req.getParameter("emp_Id");
		System.out.println(eid);
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			String sql = "Delete From employees where employee_id = ?";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, eid);
			
			int r = psmt.executeUpdate();
			System.out.println("처리된 건수 : " + r);
			
			resp.sendRedirect("empList");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("employee_Id : " + eid);
	}
}
