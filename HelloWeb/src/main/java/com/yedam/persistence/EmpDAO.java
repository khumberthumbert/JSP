package com.yedam.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

import domain.Employee;

public class EmpDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public void close() {
		try {
			if(conn!= null) {
				conn.close();
			}
			if(psmt != null) {
				psmt.close();
				
			}if(rs != null) {
				rs.close();
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	//사원등록.
	public boolean insertEmployee(Employee emp) {
		conn = DAO.getConnect();
		
		String sql = " insert into employees(employee_id, last_name, email, hire_date, job_id, first_name)\r\n"
				+ "values(employees_seq.nextval, ?, ?, ?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getLastName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getHireDate());
			psmt.setString(4, emp.getJobId());
			psmt.setString(5, emp.getFirstName());
			
			int r = psmt.executeUpdate();
			System.out.println("처리된 건수: " + r);
			if(r>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
		return false;
	}
	
	//사원목록
	public List<Employee> getEmpList() {
		List<Employee> list = new ArrayList<>(); //List라는 인터페이스.
		String sql = "select * from employees order by 1 desc";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getString("hire_date"));
				
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
}
