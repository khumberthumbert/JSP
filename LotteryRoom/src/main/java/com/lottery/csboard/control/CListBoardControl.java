package com.lottery.csboard.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lottery.FrontControl.Control;
import com.lottery.csboard.domain.CSVO;
import com.lottery.csboard.service.CSBoardService;
import com.lottery.csboard.service.CSBoardServiceImpl;

public class CListBoardControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cbGrade = req.getParameter("cbGrade");
		
		CSBoardService service = new CSBoardServiceImpl();
		List<CSVO> list = service.ListSc(cbGrade);
		req.setAttribute("listInfo", list);
		return "board/boardList.tiles";
	}
}