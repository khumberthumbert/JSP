package com.lottery.csboard.control;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lottery.FrontControl.Control;
import com.lottery.csboard.domain.CSVO;
import com.lottery.csboard.service.CSBoardService;
import com.lottery.csboard.service.CSBoardServiceImpl;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CAddBoardControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getMethod().equals("GET")) {
			return "board/boardAdd.tiles";
		}else if(req.getMethod().equals("POST")) {
			String saveDir = req.getServletContext().getRealPath("images");
			int maxSize = 5 * 1024 * 1024;
			String encoding = "UTF-8";
			DefaultFileRenamePolicy rn = new DefaultFileRenamePolicy();
			MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, encoding, rn);
			
			Enumeration<?> enu = multi.getFileNames();
			while(enu.hasMoreElements()) {
				String file = (String) enu.nextElement();
				System.out.println("file : " + file);
			}
			String userName = multi.getParameter("userName");
			String cbSubject = multi.getParameter("cbSubject");
			String cbTitle = multi.getParameter("cbTitle");
			String cbAttach = multi.getParameter("cbAttach");
			
			CSVO vo = new CSVO();
			vo.setCbAttach(cbAttach);
			vo.setCbTitle(cbTitle);
			vo.setUserName(userName);
			vo.setCbSubject(cbSubject);
			
			CSBoardService service = new CSBoardServiceImpl();
			
			if(service.addBoard(vo)) {
				return "boardList.do";
			} else {
				return "main.do";
			}
		}
		return null;
	}

}
