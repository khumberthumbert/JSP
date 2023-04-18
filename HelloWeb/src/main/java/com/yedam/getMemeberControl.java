package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

import domain.Employee;

public class getMemeberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//매개값으로 사원번호.
		String empId = req.getParameter("emp_Id");
		EmpDAO dao = EmpDAO.getInstance();
		Employee emp = dao.getEmp(Integer.parseInt(empId));
		req.setAttribute("empInfo", emp);
		// 페이지 재지정.control -> getMember.jsp
		try {
			req.getRequestDispatcher("WEB-INF/views/getMember.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
