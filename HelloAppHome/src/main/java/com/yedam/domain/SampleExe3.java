package com.yedam.domain;

import java.util.List;

import com.yedam.notice.domain.ReplyVO;
import com.yedam.notice.service.ReplyService;
import com.yedam.notice.service.ReplyServiceImpl;

public class SampleExe3 {
	public static void main(String[] args) {
		//String nid = req.getParameter("nid");
		ReplyService service = new ReplyServiceImpl();
		List<ReplyVO> list = service.getReplies(100);
		
		for(ReplyVO vo : list) {
			System.out.println(vo);
		}
		
		
//		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();
//		try (SqlSession session = sqlSessionFactory.openSession(true)) { //true -> 자동커밋
//			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
//			
//			List<NoticeVO> list = mapper.noticeWithPage(1);
//			for(NoticeVO vo : list) {
//				System.out.println(vo);
//			}
//		
//	
//	}
		
		
	}
}
