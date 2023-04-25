package com.yedam.member.mapper;

import com.yedam.member.domain.MemberVO;

public interface MemberMapper {
	public MemberVO loginCheck(MemberVO vo);
	public MemberVO searchMember(String memberId);
	public int updateMember(MemberVO vo);
	
}
