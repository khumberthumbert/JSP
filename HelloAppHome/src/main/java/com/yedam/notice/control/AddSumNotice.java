package com.yedam.notice.control;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class AddSumNotice implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   NoticeService service = new NoticeServiceImpl();
		//Enumeration<?> enu = multi.getFileNames();
		if (req.getMethod().equals("GET")) {
			String nid = req.getParameter("nid");
			
			NoticeVO vo = service.getNotice(Integer.parseInt(nid));
			req.setAttribute("noticeInfo", vo);
			
			
		} else if(req.getMethod().equals("POST")) {
			String writer = req.getParameter("writer");
			String subject = req.getParameter("subject");
			String title = req.getParameter("title");
			// 사용자의 입력값을 NoticeVO 입력.
			NoticeVO vo = new NoticeVO();
			vo.setNoticeSubject(subject);
			vo.setNoticeTitle(title);
			vo.setNoticeWriter(writer);
	
			// 정상처리 -> 목록이동.
			if (service.addNotice(vo)) {
				return "noticeList.do";
			} else {
				return "main.do";
			}
	}	return "notice/noticeAddForm.tiles";
	}
}
