package com.lottery.csboard.mapper;

import java.util.List;

import com.lottery.csboard.domain.CSVO;

public interface CSBoardMapper {
	
	public List<CSVO> csList(String cbGrade);
	
	public CSVO searchBoard(int cbId);
	
	public int insertBoard(CSVO vo);
	
	public int deleteBoard(int cbId);
	
	public int updateBoard(CSVO vo);
}