package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

import domain.Employee;

public class AddMemberControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		String fname = req.getParameter("fname"); //input name="fname"
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String job = req.getParameter("job");
		String hdate = req.getParameter("hdate");
		
		Employee emp = new Employee();
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setEmail(email);
		emp.setJobId(job);
		emp.setHireDate(hdate);
		
		EmpDAO dao = EmpDAO.getInstance(); 
			try {
				if(dao.insertEmployee(emp)) {
					resp.sendRedirect("main.do");
				}else {
					resp.sendRedirect("addMemberForm.do");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
		
	}
