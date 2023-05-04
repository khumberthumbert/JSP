package com.lottery.csboard.service;

import java.util.List;

import com.lottery.csboard.domain.CSVO;

public interface CSBoardService {
	
	public List<CSVO> ListSc(String cbGrade);
	
	public CSVO getBoard(int cbId);
	
	public boolean addBoard(CSVO vo);
	
	public boolean removeBoard(int cbId);
}