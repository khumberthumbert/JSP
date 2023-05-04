package com.lottery.FrontControl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lottery.csboard.control.CAddBoardControl;
import com.lottery.csboard.control.CListBoardControl;
import com.lottery.csboard.control.CModifyBoardControl;
import com.lottery.csboard.control.CRemoveBoardControl;
import com.lottery.csboard.control.CgetListControl;
import com.lottery.multiboard.control.ListBoardControl;


public class FrontController extends HttpServlet {

	private Map<String, Control> map;
	String encoding;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		// 메인화면
		map.put("/main.do", new MainControl());
		
		// 공지사항
		map.put("/listBoard.do", new ListBoardControl()); // 멀티게시판 리스트 조회(공용)
		
		//고객센터
		map.put("/cboardList.do",new CListBoardControl());//전체조회
		
		map.put("/cgetBoard.do", new CgetListControl());//단건조회
		map.put("/caddBoard.do", new CAddBoardControl());//등록
		map.put("/cmodifyBoard.do", new CModifyBoardControl()); //수정
		map.put("/cremoveBoard.do", new CRemoveBoardControl()); //삭제
		//테스트
	}	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);

		Control control = map.get(path);
		String viewPage = control.execute(req, resp);
		System.out.println(viewPage);

		if (viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
			return;
		}
		if (viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(viewPage.substring(0,viewPage.length() - 5));
			return;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}
}
