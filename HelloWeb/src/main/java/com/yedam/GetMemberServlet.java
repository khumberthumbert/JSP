package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

import domain.Employee;

@WebServlet("/getMemberServlet")
public class GetMemberServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String empId = req.getParameter("emp_id");
		Employee result = EmpDAO.getInstance().getEmp(Integer.valueOf(empId));
		if(result != null) {
			out.print("<table border='1'>");
			out.print("<tr>");
			out.print("<th>사원번호</th>");
			out.print("<td>"+result.getEmployeeId()+"</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<th>이름</th>");
			out.print("<td>"+result.getFirstName()+ ", " +result.getLastName()+"</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<th>잡아이디</th>");
			out.print("<td>"+result.getJobId()+ "</td>");
			out.print("</tr>");
			out.print("<tr>");
			out.print("<th>입사일</th>");
			out.print("<td>"+result.getHireDate()+ "</td>");
			out.print("</tr>");
			out.print("</table>");
			out.print("<a href='empList'>목록으로</a>");
		}else {
			resp.sendRedirect("/search.html");
		}
		
		
	}
}
