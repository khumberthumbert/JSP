package com.lottery.csboard.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lottery.FrontControl.Control;
import com.lottery.csboard.domain.CSVO;
import com.lottery.csboard.service.CSBoardService;
import com.lottery.csboard.service.CSBoardServiceImpl;

public class CModifyBoardControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CSBoardService service = new CSBoardServiceImpl();
		if(req.getMethod().equals("GET")) {
			String cbId = req.getParameter("cbId");
			
			CSVO vo = service.getBoard(Integer.parseInt(cbId));
			req.setAttribute("boardInfo", vo);
		return "board/boardModify.tiles";
		
	} else if (req.getMethod().equals("POST")) {
		String cbId = req.getParameter("cbId");
		String cbtitle = req.getParameter("cbTitle");
		String cbSubject = req.getParameter("cbSubject");
		
		CSVO vo = new CSVO();
		vo.setCbId(Integer.parseInt("cbId"));
		vo.setCbSubject(cbSubject);
		vo.setCbTitle(cbtitle);
		
//		service.boardModify(vo);  형 모르겠어 delete 하고 있던 거여써 ??
	}
		return "boardList.do";
}
}
