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

import com.yedam.persistence.EmpDAO;

@WebServlet("/delMemberServlet")
public class DelMemberServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String eid = req.getParameter("emp_Id");
		int eid2 = Integer.parseInt(eid);
		
		boolean work = EmpDAO.getInstance().deleteEmployee(eid2);
		if(work) {
			resp.sendRedirect("empList");
		}else {
			resp.sendRedirect("/delForm.html");
		}
		
		
	}
}
