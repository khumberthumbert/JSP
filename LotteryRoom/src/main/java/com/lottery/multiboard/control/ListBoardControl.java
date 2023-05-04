package com.lottery.multiboard.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lottery.FrontControl.Control;
import com.lottery.multiboard.domain.MultiVO;
import com.lottery.multiboard.service.MultiService;
import com.lottery.multiboard.service.MultiServiceImpl;

public class ListBoardControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mbGrade = req.getParameter("mbGrade");
		MultiService service = new MultiServiceImpl();
		List<MultiVO> vo = service.listBoard(mbGrade);
		
		req.setAttribute("listInfo", vo);
		
		return "multi/listmulti.tiles";
	}

}
