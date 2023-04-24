package com.yedam.notice.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServiceImpl;

public class ANControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		if(req.getMethod().equals("POST")) {
			String saveDir=req.getServletContext().getRealPath("images");
			int maxSize= 5 * 1024 * 1024;
			String encoding ="UTF-8";
			DefaultFileRenamePolicy rn = new DefaultFileRenamePolicy();
			MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, encoding);
			
			String writer = multi.getParameter("writer");
			String subject = multi.getParameter("subject");
			String title = multi.getParameter("title");
			String attach = multi.getFilesystemName("attach");
			//사용자의 입력값을 NoticeVO 입력.
			NoticeVO vo = new NoticeVO();
			vo.setAttachFile(attach);
			vo.setNoticeSubject(subject);
			vo.setNoticeTitle(title);
			vo.setNoticeWriter(writer);
			
			NoticeService service = new NoticeServiceImpl();
			// 정상처리 -> 목록이동.
		}else if(req.getMethod().equals("GET")) { 

			return "notice/noticeAddForm.tiles";
		}
		
		return "noticeList.do";
		
	}

}
