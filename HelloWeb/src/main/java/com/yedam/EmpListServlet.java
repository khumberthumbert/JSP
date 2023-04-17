package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

import domain.Employee;

@WebServlet("/empList")
public class EmpListServlet extends HttpServlet {
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		// jdbc 연결 접속 조회
//				try{
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//				} catch(ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//				
//				try {
//					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//					// 쿼리 조회 -> 처리 결과 : PreparedStatement
//					String sql = "select employee_id, first_name, last_name, email, phone_number \r\n"
//							+ "from employees";
//					PreparedStatement psmt = conn.prepareStatement(sql);
//					ResultSet rs = psmt.executeQuery(); //실행된 결과 반환
					
					out.print("<table border ='1'>");
					out.print("<thead><tr><th>사원번호</th><th>FristName</th><th>LastName</th><th>email</th><th>job_id</th></tr></thead>");
					out.print("<tbody>");
					
					
					//데이터 건수가 반복될 것.
					//while(rs.next()) {
					for(Employee emp : list) {
						//System.out.println("eid: " + rs.getInt("employee_id") + ", fName : " + rs.getString("first_name"));// 순번 번호 : 첫번째 칼럼 값을 가져오겠습니다. 그냥 칼럼 값 가져오겠습니다
						// 사원번호, fname, lname, email, phone...
						out.print("<tr><td>" + emp.getEmployeeId()
						+ "</td><td>"+emp.getFirstName()
						+ "</td><td>"+ emp.getLastName() 
						+ "</td><td>" +emp.getEmail() 
						+ "</td><td>" + emp.getJobId() 
						+ "</td></tr>");
					}
					//}
					out.print("</tbody>");
					out.print("</table>");
	}
}
					
//					conn.close();
//					psmt.close();
//					rs.close();
					
//				}catch(SQLException e) {
//					e.printStackTrace();
//				}
		
	//}
	
	
	//public static void main(String[] args) {
		
	//}

