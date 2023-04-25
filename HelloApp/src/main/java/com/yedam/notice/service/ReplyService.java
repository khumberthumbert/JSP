package com.yedam.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.notice.domain.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> getReplies(int noticeId);
	public boolean addReply(ReplyVO vo);
	public boolean removeReply(int replyId);
	//public ReplyVO updateReply
	public boolean updateReply(ReplyVO vo);
	public ReplyVO searchReply(int replyId);
}
