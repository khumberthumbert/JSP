package com.lottery.csboard.control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lottery.FrontControl.Control;
import com.lottery.csboard.domain.CSVO;
import com.lottery.csboard.service.CSBoardService;
import com.lottery.csboard.service.CSBoardServiceImpl;

public class CgetListControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cbId = req.getParameter("cbId");
		System.out.println(cbId);
		System.out.println("11");
		CSBoardService service = new CSBoardServiceImpl();
		System.out.println(service.getBoard(Integer.parseInt(cbId)));
		CSVO vo = service.getBoard(Integer.parseInt(cbId));
		System.out.println("22");
		
		System.out.println(vo);
		
		req.setAttribute("boardInfo", vo);
		
		if(vo.getCbAttach() != null) {
			String imgPath = req.getServletContext().getRealPath("images");
			Path file = Paths.get(imgPath + "/" + vo.getCbAttach());
			System.out.println(Files.probeContentType(file));
			String fileType = Files.probeContentType(file);
			req.setAttribute("fileType", fileType.substring(0, fileType.indexOf("/")));
			
		}
		return "board/boardGet.tiles";
	}

}
