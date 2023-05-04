package com.lottery.multiboard.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lottery.FrontControl.Control;
import com.lottery.multiboard.domain.MultiVO;
import com.lottery.multiboard.service.MultiService;
import com.lottery.multiboard.service.MultiServiceImpl;

public class GetMultiControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mbId = req.getParameter("multiId");
		String mbGrade = req.getParameter("multiGrade");
		
		MultiVO multi = new MultiVO();
		
		multi.setMbId(Integer.parseInt(mbId));
		multi.setMbGrade(mbGrade);
		
		MultiService service = new MultiServiceImpl();
		
		MultiVO vo = service.getMulti(multi);
		req.setAttribute("boardInfo", vo);
		
		String control = "";
		if(mbGrade.equals("K")) {
			control = "modifyKMulti.do";
		} else if(mbGrade.equals("E")) {
			control = "modifyEMulti.do";
		} else if(mbGrade.equals("J")) {
			control = "modifyJMulti.do";
		}
		req.setAttribute("control", control);
		
		return "multi/getmulti.tiles";
	}

}
