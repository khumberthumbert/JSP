package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.persistence.EmpDAO;

import domain.Employee;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		// 사원번호(100), 이메일(SKING)
		String empId = req.getParameter("uname");
		String email = req.getParameter("psw");
		
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(empId));
		emp.setEmail(email);
		System.out.println("1: " + emp);
		
		EmpDAO dao = EmpDAO.getInstance();
		emp = dao.loginCheck(emp);
		System.out.println("2: " + emp);
		
		try {
			
			if(emp == null) {
				resp.sendRedirect("loginForm.do");
			} else {
				// request객체 / session객체
				req.setAttribute("reqInfo", emp.getFirstName());
				
				HttpSession session = req.getSession();
				session.setAttribute("sesInfo", emp.getLastName());
				
				resp.sendRedirect("main.do"); // sendRedirect -> 파라미터값을 감지를 못함.
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
