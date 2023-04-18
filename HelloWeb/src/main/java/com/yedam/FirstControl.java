package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

import domain.Employee;

public class FirstControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("firstcontrol 실행.");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e	) {
			e.printStackTrace();
		}
		
		List<Employee> list = EmpDAO.getInstance().getEmpList();
		
		out.print("<table border ='1'>");
		out.print("<thead><tr><th>사원번호</th><th>FristName</th><th>LastName</th><th>email</th><th>job_id</th></tr></thead>");
		out.print("<tbody>");
		
		
		//데이터 건수가 반복될 것.
		for(Employee emp : list) {
			out.print("<tr><td><a href='getMemberServlet?emp_id="+ emp.getEmployeeId() +"'>" + emp.getEmployeeId()
			+ "</a></td><td>"+emp.getFirstName()
			+ "</td><td>"+ emp.getLastName() 
			+ "</td><td>" +emp.getEmail() 
			+ "</td><td>" + emp.getJobId() 
			+ "</td></tr>");
		}
		out.print("</tbody>");
		out.print("</table>");
	}

}
