package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

public class DeleteMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// TODO DB 삭제처리.
		String empId = req.getParameter("emp_Id");
		
		EmpDAO dao = EmpDAO.getInstance();
		try {
		if(dao.deleteEmployee(Integer.parseInt(empId))) {
				resp.sendRedirect("main.do");
			} else {
				resp.sendRedirect("modifyMember.do?emp_id="+empId);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
