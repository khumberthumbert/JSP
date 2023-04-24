package com.yedam.notice.mapper;

import java.util.List;

import com.yedam.notice.domain.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> replyList(int noticeId); //매개값 원본 글이 들어가야함. , xml 파일 있어야함.
	//댓글 등록.
	public int insertReply(ReplyVO vo);
	
}	
