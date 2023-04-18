package com.yedam;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

import domain.Employee;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 페이지 재지정.
			//resp.sendRedirect();
			EmpDAO dao = EmpDAO.getInstance();
			List<Employee> list = dao.getEmpList();
			
			req.setAttribute("listInfo", list);
			
			RequestDispatcher rd =req.getRequestDispatcher("WEB-INF/views/emplist.jsp");
			rd.forward(req, resp);
			//.jsp 는 view 역할을 함. 기능은 Controller에 구현.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
