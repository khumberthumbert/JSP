package com.lottery.csboard.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lottery.FrontControl.Control;
import com.lottery.csboard.service.CSBoardService;
import com.lottery.csboard.service.CSBoardServiceImpl;

public class CRemoveBoardControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cbId = req.getParameter("cbId");
		CSBoardService service = new CSBoardServiceImpl();
		boolean result = service.removeBoard(Integer.parseInt(cbId));
		
		if(result) {
			return "boardList.do";
		} else {
			return "getBoard.do?cbId=cbId";
		}
	}

}
