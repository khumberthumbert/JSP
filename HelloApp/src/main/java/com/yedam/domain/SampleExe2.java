package com.yedam.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.notice.mapper.NoticeMapper;
import com.yedam.notice.domain.NoticeVO;

public class SampleExe2 {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = com.yedam.common.DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			NoticeVO nvo = new NoticeVO();
			nvo.setNoticeId(3);
			nvo.setNoticeWriter("user05");
			nvo.setNoticeTitle("ttestt");
			nvo.setNoticeSubject("글 내용 입니다.잉잉dld잉잉잉ㄴ");
			//mapper.insertNotice(nvo);
			mapper.updateNotice(nvo);
			//mapper.deleteNotice(4);
			//System.out.println(mapper.searchNotice(3));
			
					
			for(NoticeVO vo : mapper.noticeList()) {
				System.out.println(vo);
			}
			
//			Employee empl = new Employee();
//			empl.setEmployeeId(310);
//			empl.setLastName("Hong");
//			empl.setEmail("hon1n@email");
//			empl.setJobId("IT_PROG");
//			
//			mapper.addEmp(empl);
//			session.commit();
//			
//			Employee emp = mapper.getEmp(310);
//			System.out.println(emp);
		}
	}
}
