package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

import domain.Employee;

public class ModifyMemberControl implements Control {

	//View에서 요청한 method을 구분해주는 메소드. GET/POST 체크해줌.
	

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getMethod().equals("GET")) {
		// emp_Id 파라미터 . 넘어옴.
		// MVC 패턴. 컨트롤러에서 DB의 처리. View화면으로 정보를 전송.
		// emp 변수에 조회결과를 담아서 empInfo의 속성으로 modifyMember.jsp 재지정.
		String empId = req.getParameter("emp_Id");
		EmpDAO dao = EmpDAO.getInstance();
		Employee emp = dao.getEmp(Integer.parseInt(empId));
		
		req.setAttribute("empInfo", emp);
		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/modifyMember.jsp");
		try {
			rd.forward(req, resp);
		}catch(ServletException | IOException e) {
			e.printStackTrace();
		}
	} else if(req.getMethod().equals("POST")){
		//DB 업데이트 처리. 목록이동.
		String empId = req.getParameter("emp_Id");
		String fName = req.getParameter("first_name");
		String lName = req.getParameter("last_name");
		String email = req.getParameter("email");
		
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(empId));
		emp.setFirstName(fName);
		emp.setLastName(lName);
		emp.setEmail(email);
		
		EmpDAO dao = EmpDAO.getInstance();
		boolean result = dao.updateMember(emp);
		try {
			if(result) {
				resp.sendRedirect("main.do");
			} else {
				resp.sendRedirect("modifyMember.do");
			}
		} catch(Exception e) {
			
		}
		
		}
}
}

