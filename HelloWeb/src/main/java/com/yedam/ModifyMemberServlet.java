package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

import domain.Employee;

@WebServlet("/modifyMemberServlet")
public class ModifyMemberServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String empId = req.getParameter("emp_Id");
		String fname = req.getParameter("first_name");
		String lname = req.getParameter("last_name");
		String email = req.getParameter("email");
		
		Employee emp = new Employee();
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setEmail(email);
		emp.setEmployeeId(Integer.parseInt(empId));
		
		EmpDAO dao = EmpDAO.getInstance();
		
		boolean result = dao.updateMember(emp);
		try {
			if(result) {
				resp.sendRedirect("emplist.jsp");
			} else {
				resp.sendRedirect("/modifyMember.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
	}
	
	
	
	
}
